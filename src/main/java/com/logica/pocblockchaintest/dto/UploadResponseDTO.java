package com.logica.pocblockchaintest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResponseDTO {

    private String customerName;
    private String customerSex;
    private String permanentAddress;
    private int wardNumber;

}
