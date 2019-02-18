package com.logica.pocblockchaintest.controller;

import com.logica.pocblockchaintest.dto.StatementDTO;
import com.logica.pocblockchaintest.dto.TransactionReceiptDTO;
import com.logica.pocblockchaintest.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    Transaction transaction;

    @Autowired
    Web3j web3j;

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

    @GetMapping("{customerName}")
    public ResponseEntity getCustomer(@PathVariable String customerName) throws Exception {
        return ResponseEntity.ok(transaction.getCustomer(customerName).send());
    }

    @PostMapping("request")
    public ResponseEntity<TransactionReceiptDTO> requestBalanceUpdate(@RequestBody StatementDTO statementDTO) throws Exception{
        TransactionReceiptDTO transactionReceiptDTO = transactionReceiptMapper(transaction.requestBalanceUpdate(statementDTO.getCustomerName(), statementDTO.getBankName(), statementDTO.getMessage(), statementDTO.getBalance()).send());
        return new ResponseEntity<>(transactionReceiptDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("balance/{customerName}")
    public BigInteger getBalance(@PathVariable String customerName) throws Exception {
        return transaction.getBalance(customerName).send();
    }

}
