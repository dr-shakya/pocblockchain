package com.logica.pocblockchaintest.controller;

import com.logica.pocblockchaintest.dto.BankDTO;
import com.logica.pocblockchaintest.dto.CustomerDTO;
import com.logica.pocblockchaintest.dto.TransactionReceiptDTO;
import com.logica.pocblockchaintest.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;

import java.math.BigInteger;

@RestController
@RequestMapping("bank")
public class BankController {

    public final static Logger LOGGER = LoggerFactory.getLogger(BankController.class);

    @Autowired
    Transaction transaction;

    @Autowired
    Web3j web3j;

    @Autowired
    Admin admin;

    public TransactionReceiptDTO transactionReceiptMapper(TransactionReceipt transactionReceipt){
        TransactionReceiptDTO transactionReceiptDTO = new TransactionReceiptDTO();
        transactionReceiptDTO.setTransactionHash(transactionReceipt.getTransactionHash());
        transactionReceiptDTO.setTransactionIndex(transactionReceipt.getTransactionIndex());
        transactionReceiptDTO.setBlockHash(transactionReceipt.getBlockHash());
        transactionReceiptDTO.setBlockNumber(transactionReceipt.getBlockNumber());
        transactionReceiptDTO.setCumulativeGasUsed(transactionReceipt.getCumulativeGasUsed());
        transactionReceiptDTO.setGasUsed(transactionReceipt.getGasUsed());
        transactionReceiptDTO.setContractAddress(transactionReceipt.getContractAddress());
        transactionReceiptDTO.setRoot(transactionReceipt.getRoot());
        transactionReceiptDTO.setStatus(transactionReceipt.getStatus());
        transactionReceiptDTO.setFrom(transactionReceipt.getFrom());
        transactionReceiptDTO.setTo(transactionReceipt.getTo());
        return transactionReceiptDTO;
    }

    @GetMapping("{bankName}")
    public ResponseEntity getBank(@PathVariable String bankName) throws Exception {
        return ResponseEntity.ok(transaction.getBank(bankName).send());
    }

    @GetMapping("balance/{customerName}")
    public ResponseEntity getBalance(@PathVariable String customerName) throws Exception {
        return ResponseEntity.ok(transaction.getBalance(customerName).send());
    }

    @PostMapping
    public ResponseEntity<TransactionReceiptDTO> addBank(@RequestBody BankDTO bankDTO) throws Exception {
        String bankAddress = String.valueOf(admin.personalNewAccount(bankDTO.getAccountPassword()).send().getAccountId());
        TransactionReceiptDTO transactionReceiptDTO = transactionReceiptMapper(transaction.setBank(bankDTO.getBankName(), bankDTO.getAccountPassword(), bankAddress).send());
        return new ResponseEntity<>(transactionReceiptDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("customer")
    public ResponseEntity<TransactionReceiptDTO> addCustomer(@RequestBody CustomerDTO customerDTO) throws Exception{
        String customerAddress = String.valueOf(admin.personalNewAccount(customerDTO.getAccountPassword()).send().getAccountId());
        TransactionReceiptDTO transactionReceiptDTO = transactionReceiptMapper(transaction.setCustomer(customerDTO.getBankName(), customerDTO.getCustomerName(), customerDTO.getAccountPassword(), customerDTO.getBalance(), customerAddress).send());
        return new ResponseEntity<>(transactionReceiptDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("verify/{bankName}")
    public ResponseEntity<TransactionReceiptDTO> verifyStatement(@PathVariable String bankName) throws Exception{
        TransactionReceiptDTO transactionReceiptDTO = transactionReceiptMapper(transaction.verifyStatement(bankName).send());
        return new ResponseEntity<>(transactionReceiptDTO, HttpStatus.ACCEPTED);
    }
}
