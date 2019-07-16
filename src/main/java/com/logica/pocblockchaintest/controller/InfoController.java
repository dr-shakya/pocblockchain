package com.logica.pocblockchaintest.controller;

import com.logica.pocblockchaintest.dto.BankDTO;
import com.logica.pocblockchaintest.dto.NewCustomerDTO;
import com.logica.pocblockchaintest.dto.TransactionReceiptDTO;
import com.logica.pocblockchaintest.services.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.tuples.generated.Tuple3;

import java.math.BigInteger;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class InfoController {

    private final Web3j web3j;

    private final InfoService infoService;

    @PostMapping("bank")
    public ResponseEntity<TransactionReceiptDTO> setBank(@RequestBody BankDTO bankDTO) throws Exception {
        return new ResponseEntity<>(infoService.setBank(bankDTO), HttpStatus.OK);
    }

    @PostMapping("customer")
    public ResponseEntity<TransactionReceiptDTO> setCustomer(@RequestBody NewCustomerDTO customerDTO) throws Exception{
        return new ResponseEntity<>(infoService.setCustomer(customerDTO), HttpStatus.OK);
    }

    @GetMapping("/bank/{bankName}")
    public ResponseEntity<Tuple3<BigInteger, String, String>> getBank(@PathVariable String bankName) throws Exception {
        return ResponseEntity.ok(infoService.getBank(bankName));
    }

    @GetMapping("/customer/{customerName}")
    public ResponseEntity getCustomer(@PathVariable String customerName) throws Exception {
        return ResponseEntity.ok(infoService.getCustomer(customerName));
    }


}
