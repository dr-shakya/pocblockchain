package com.logica.pocblockchaintest.controller;

import com.logica.pocblockchaintest.dto.StatementDTO;
import com.logica.pocblockchaintest.dto.TransactionReceiptDTO;
import com.logica.pocblockchaintest.model.Transaction;
import com.logica.pocblockchaintest.services.mapper.TransactionMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final Transaction transaction;

    private final TransactionMapperService transactionMapperService;
    @GetMapping("{customerName}")
    public ResponseEntity getCustomer(@PathVariable String customerName) throws Exception {
        return ResponseEntity.ok(transaction.getCustomer(customerName).send());
    }

    @PostMapping("request")
    public ResponseEntity<TransactionReceiptDTO> requestBalanceUpdate(@RequestBody StatementDTO statementDTO) throws Exception{
        TransactionReceiptDTO transactionReceiptDTO = transactionMapperService.transactionReceiptMapper(transaction.requestBalanceUpdate(statementDTO.getCustomerName(), statementDTO.getBankName(), statementDTO.getMessage(), statementDTO.getBalance()).send());
        return new ResponseEntity<>(transactionReceiptDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("balance/{customerName}")
    public BigInteger getBalance(@PathVariable String customerName) throws Exception {
        return transaction.getBalance(customerName).send();
    }

}
