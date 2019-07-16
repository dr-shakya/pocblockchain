package com.logica.pocblockchaintest.controller;

import com.logica.pocblockchaintest.dto.UploadResponseDTO;
import com.logica.pocblockchaintest.services.FileService;
import com.logica.pocblockchaintest.services.impl.FileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @CrossOrigin(origins = "*")
    @PostMapping("uploadpicture")
    public ResponseEntity<UploadResponseDTO> handleFileUpload(@RequestBody MultipartFile file) throws IOException{

        fileService.store(file);
//        return ResponseEntity.ok("You successfully uploaded " + file.getOriginalFilename());
        UploadResponseDTO uploadResponseDTO = fileService.extractWords(fileService.parseImage(file.getOriginalFilename()));
        return new ResponseEntity<>(uploadResponseDTO, HttpStatus.OK);
    }

}
