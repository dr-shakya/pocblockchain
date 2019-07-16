package com.logica.pocblockchaintest.services.impl;

import com.logica.pocblockchaintest.dto.BankDTO;
import com.logica.pocblockchaintest.dto.NewCustomerDTO;
import com.logica.pocblockchaintest.dto.TransactionReceiptDTO;
import com.logica.pocblockchaintest.model.Info;
import com.logica.pocblockchaintest.services.InfoService;
import com.logica.pocblockchaintest.services.mapper.TransactionMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.protocol.admin.Admin;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple6;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService {

    private final Info info;

    private final Admin admin;

    private final TransactionMapperService transactionMapperService;

    @Override
    public TransactionReceiptDTO setBank(BankDTO bankDTO) throws Exception {
        String bankAddress = admin.personalNewAccount(bankDTO.getAccountPassword()).send().getAccountId();
        return transactionMapperService.transactionReceiptMapper(info.setBank(bankDTO.getBankName(), bankDTO.getAccountPassword(), bankAddress).send());
    }

    @Override
    public TransactionReceiptDTO setCustomer(NewCustomerDTO customerDTO) throws Exception {
        String customerAddress = admin.personalNewAccount(customerDTO.getAccountPassword()).send().getAccountId();
        return transactionMapperService.transactionReceiptMapper(info.setCustomer(customerDTO.getBankName(), customerDTO.getCustomerName(), customerDTO.getCustomerSex(), customerDTO.getPermanentAddress(), customerDTO.getWardNumber(), customerAddress, customerDTO.getAccountPassword()).send());
    }

    @Override
    public Tuple3<BigInteger, String, String> getBank(String bankName) throws Exception {
        return info.getBank(bankName).send();
    }

    @Override
    public Tuple6<BigInteger, String, String, String, BigInteger, String> getCustomer(String customerName) throws Exception {
        return info.getCustomer(customerName).send();
    }

}
