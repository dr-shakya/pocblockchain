package com.logica.pocblockchaintest.controller;

import com.logica.pocblockchaintest.dto.BankDTO;
import com.logica.pocblockchaintest.dto.CustomerDTO;
import com.logica.pocblockchaintest.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;

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

    @GetMapping("{bankName}")
    public ResponseEntity getBank(@PathVariable String bankName) throws Exception {
        return ResponseEntity.ok(transaction.getBank(bankName).send());
    }

    @GetMapping("balance/{customerName}")
    public ResponseEntity getBalance(@PathVariable String customerName) throws Exception {
        return ResponseEntity.ok(transaction.getBalance(customerName).send());
    }

    @PostMapping
    public ResponseEntity addBank(@RequestBody BankDTO bankDTO) throws Exception {
        String bankAddress = String.valueOf(admin.personalNewAccount(bankDTO.getAccountPassword()).send().getAccountId());
        return ResponseEntity.ok(transaction.setBank(bankDTO.getBankName(), bankDTO.getAccountPassword(), bankAddress).send());
    }

    @PostMapping("customer")
    public ResponseEntity addCustomer(@RequestBody CustomerDTO customerDTO) throws Exception{
        String customerAddress = String.valueOf(admin.personalNewAccount(customerDTO.getAccountPassword()).send().getAccountId());
        return ResponseEntity.ok(transaction.setCustomer(customerDTO.getBankName(), customerDTO.getCustomerName(), customerDTO.getAccountPassword(), customerDTO.getBalance(), customerAddress).send());
    }

    @PostMapping("verify/{bankName}")
    public ResponseEntity verifyStatement(@PathVariable String bankName) throws Exception{
        return ResponseEntity.ok(transaction.verifyStatement(bankName).send());
    }
}
