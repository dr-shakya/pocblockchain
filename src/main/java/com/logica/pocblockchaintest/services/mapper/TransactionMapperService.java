package com.logica.pocblockchaintest.services.mapper;

import com.logica.pocblockchaintest.dto.TransactionReceiptDTO;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Service
public class TransactionMapperService {

    public static TransactionReceiptDTO transactionReceiptMapper(TransactionReceipt transactionReceipt){
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

}
