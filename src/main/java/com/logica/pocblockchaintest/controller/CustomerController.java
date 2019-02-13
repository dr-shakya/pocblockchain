package com.logica.pocblockchaintest.controller;

import com.logica.pocblockchaintest.dto.StatementDTO;
import com.logica.pocblockchaintest.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.RemoteCall;

import java.math.BigInteger;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    Transaction transaction;

    @Autowired
    Web3j web3j;

    @GetMapping("{customerName}")
    public ResponseEntity getCustomer(@PathVariable String customerName) throws Exception {
        return ResponseEntity.ok(transaction.getCustomer(customerName).send());
    }

    @PostMapping("request")
    public ResponseEntity requestBalanceUpdate(@RequestBody StatementDTO statementDTO) throws Exception{
        return ResponseEntity.ok(transaction.requestBalanceUpdate(statementDTO.getCustomerName(), statementDTO.getBankName(), statementDTO.getMessage(), statementDTO.getBalance()).send());
    }

    @GetMapping("balance/{customerName}")
    public BigInteger getBalance(@PathVariable String customerName) throws Exception {
        return transaction.getBalance(customerName).send();
    }

}
