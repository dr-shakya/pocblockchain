package com.logica.pocblockchaintest.services;

import com.logica.pocblockchaintest.dto.BankDTO;
import com.logica.pocblockchaintest.dto.NewCustomerDTO;
import com.logica.pocblockchaintest.dto.TransactionReceiptDTO;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple6;

import java.math.BigInteger;

public interface InfoService {

    TransactionReceiptDTO setBank(BankDTO bankDTO) throws Exception;

    TransactionReceiptDTO setCustomer(NewCustomerDTO customerDTO) throws Exception;

    Tuple3<BigInteger, String, String> getBank(String bankName) throws Exception;

    Tuple6<BigInteger, String, String, String, BigInteger, String> getCustomer(String customerName) throws Exception;
}
