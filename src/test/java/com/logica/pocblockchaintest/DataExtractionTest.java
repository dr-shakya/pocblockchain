package com.logica.pocblockchaintest;

import com.logica.pocblockchaintest.model.CitizenInformation;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataExtractionTest {

    @Test
    public void givenList_extractNecessaryData() {
        List<String> predictions = Arrays.asList("aaa:", "Full", "Name:", "Digbijaya", "Shakya", " ", "", "Sex:", "Male", "adf", "Ward", "No.:", "9");

        Map<String, CitizenInformation> informationMap = new HashMap<>();
        informationMap.put("Name:", new CitizenInformation("Name:", "Full", "", 0, 2));
        informationMap.put("Sex:", new CitizenInformation("Sex:", "", "", 0, 1));
//        informationMap.put("District:", new CitizenInformation("District:", "", "", 0, 1));
//        informationMap.put("No.", new CitizenInformation("No.:","Ward", "", 1));
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

    }


}
