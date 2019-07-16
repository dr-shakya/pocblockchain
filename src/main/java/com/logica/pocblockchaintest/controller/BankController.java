package com.logica.pocblockchaintest.controller;

import com.logica.pocblockchaintest.dto.BankDTO;
import com.logica.pocblockchaintest.dto.CustomerDTO;
import com.logica.pocblockchaintest.dto.TransactionReceiptDTO;
import com.logica.pocblockchaintest.model.Transaction;
import com.logica.pocblockchaintest.services.mapper.TransactionMapperService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;

@RestController
@RequestMapping("bank")
@RequiredArgsConstructor
public class BankController {

    public final static Logger LOGGER = LoggerFactory.getLogger(BankController.class);

    private final Transaction transaction;

    private final Web3j web3j;

    private final Admin admin;

    @GetMapping("{bankName}")
    public ResponseEntity getBank(@PathVariable String bankName) throws Exception {
        return ResponseEntity.ok(transaction.getBank(bankName).send());
    }

    @GetMapping("balance/{customerName}")
    public ResponseEntity getBalance(@PathVariable String customerName) throws Exception {
        return ResponseEntity.ok(transaction.getBalance(customerName).send());
    }

    @PostMapping
    public ResponseEntity<?> addBank(@RequestBody BankDTO bankDTO) throws Exception {
        String bankAddress = String.valueOf(admin.personalNewAccount(bankDTO.getAccountPassword()).send().getAccountId());
        TransactionReceiptDTO transactionReceiptDTO = TransactionMapperService.transactionReceiptMapper(transaction.setBank(bankDTO.getBankName(), bankDTO.getAccountPassword(), bankAddress).send());
        return new ResponseEntity<>(transactionReceiptDTO, HttpStatus.OK);
    }

    @PostMapping("customer")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) throws Exception{
        String customerAddress = String.valueOf(admin.personalNewAccount(customerDTO.getAccountPassword()).send().getAccountId());
        TransactionReceiptDTO transactionReceiptDTO = TransactionMapperService.transactionReceiptMapper(transaction.setCustomer(customerDTO.getBankName(), customerDTO.getCustomerName(), customerDTO.getAccountPassword(), customerDTO.getBalance(), customerAddress).send());
        return new ResponseEntity<>(transactionReceiptDTO, HttpStatus.OK);
    }

    @PostMapping("verify/{bankName}")
    public ResponseEntity<?> verifyStatement(@PathVariable String bankName) throws Exception{
        TransactionReceiptDTO transactionReceiptDTO = TransactionMapperService.transactionReceiptMapper(transaction.verifyStatement(bankName).send());
        return new ResponseEntity<>(transactionReceiptDTO, HttpStatus.OK);
    }
}
