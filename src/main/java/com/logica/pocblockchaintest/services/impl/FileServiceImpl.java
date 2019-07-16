package com.logica.pocblockchaintest.services.impl;

import com.logica.pocblockchaintest.dto.UploadResponseDTO;
import com.logica.pocblockchaintest.model.CitizenInformation;
import com.logica.pocblockchaintest.services.FileService;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.bytedeco.javacpp.lept.pixDestroy;

@Service
public class FileServiceImpl implements FileService {

    private final Path outputLocation = Paths.get("C:\\[Workspace] Java\\pocblockchaintest\\output\\image-output");

    @Override
    public void store(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), outputLocation.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> parseImage(String fileName) throws IOException {

        BytePointer outText;
        TessBaseAPI api = new TessBaseAPI();

        if (api.Init("./tessdata/", "eng", 1) != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        PIX image = lept.pixRead("./output/image-output/" + fileName);
        api.SetImage(image);

        // get tsv output
        outText = api.GetTSVText(0);
        String outTextString = outText.getString();
        CsvReadOptions.Builder builder = CsvReadOptions.builderFromString(outTextString)
                .separator('\t')
                .header(false);

        CsvReadOptions options = builder.build();
        Table table = Table.read().usingOptions(options);

        // Taking a particular column
        Column column = table.column(11);
        System.out.println("Column: \n" + column.asList());


//
//        String customerName = column.getString(52) + " " + column.getString(53);
//        String customerSex = column.getString(55);
//        String permanentAddress = column.getString(92);
//        int wardNumber = Integer.parseInt(column.getString(85));

        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);


        return column.asList();

    }

    @Override
    public UploadResponseDTO extractWords(List<String> predictions) {
        Map<String, CitizenInformation> informationMap = new HashMap<>();
        informationMap.put("Name:", new CitizenInformation("Name:", "Full", "", 0, 2));
        informationMap.put("Sex:", new CitizenInformation("Sex:", "", "", 0, 1));
        informationMap.put("District:", new CitizenInformation("District:", "", "", 0, 1));
        informationMap.put("No.:", new CitizenInformation("No.:","Ward", "", 1));

        String previousWord = null;
        String currentWord = null;
        String previousKey = null;
        String currentKey = null;
        CitizenInformation citizenInformation = new CitizenInformation();

        for (String prediction: predictions) {
            if (previousWord == null) {
                previousWord = prediction;
                currentWord = prediction;
            }
            else {
                previousWord = currentWord;
                currentWord = prediction;

                if (informationMap.containsKey(prediction)) {
                    previousKey = previousWord;
                    currentKey = prediction;
                    citizenInformation = informationMap.get(currentKey);
                    if (citizenInformation.getPreviousProperty().equals("")) {
                        previousKey = "";
                    }
                }

                else if (citizenInformation.getCurrentWordCount() < citizenInformation.getWordLimit() && previousKey.equals(citizenInformation.getPreviousProperty())) {
                    String extractedValue = String.format("%1$s %2$s", citizenInformation.getValue(), prediction);
                    citizenInformation.setValue(extractedValue.trim());
                    citizenInformation.setCurrentWordCount(citizenInformation.getCurrentWordCount() + 1);
                    informationMap.put(currentKey, citizenInformation);
                }
            }
        }
        System.out.println(informationMap);

        return new UploadResponseDTO(informationMap.get("Name:").getValue(), informationMap.get("Sex:").getValue(), informationMap.get("District:").getValue(), Integer.parseInt(informationMap.get("No.:").getValue()));
    }
}
