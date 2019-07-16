package com.logica.pocblockchaintest.services;

import com.logica.pocblockchaintest.dto.UploadResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    void store(MultipartFile file);

    List<String> parseImage(String fileName) throws IOException;

    UploadResponseDTO extractWords(List<String> predictions);
}
