package com.logica.pocblockchaintest.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class NewCustomerDTO {
    private String bankName;
    private String customerName;
    private String customerSex;
    private String permanentAddress;
    private BigInteger wardNumber;
    private String accountPassword;
}
