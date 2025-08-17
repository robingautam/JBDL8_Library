package org.gfg.JBDL8_DigitalLibrary.controller;

import org.gfg.JBDL8_DigitalLibrary.model.Transaction;
import org.gfg.JBDL8_DigitalLibrary.request.BookTransactionRequest;
import org.gfg.JBDL8_DigitalLibrary.response.TransactionResponse;
import org.gfg.JBDL8_DigitalLibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @PostMapping("/book/initiate")
    public ResponseEntity<TransactionResponse> initiateTransaction(@RequestBody BookTransactionRequest bookTransactionRequest){


        TransactionResponse transactionResponse = new TransactionResponse();

        if (bookTransactionRequest==null){
            transactionResponse.setStatus("FAILED");
            transactionResponse.setMessage("Request is empty");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
        }


        Transaction transaction = transactionService.createTransaction(bookTransactionRequest);
        if (transaction==null){
            transactionResponse.setStatus("FAILED");
            transactionResponse.setMessage("Not Completed, please retry");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
        }

        transactionResponse.setTransactionType(bookTransactionRequest.getRequestType());
        transactionResponse.setBookName(transaction.getBook().getBookName());
        transactionResponse.setMessage("Book "+bookTransactionRequest.getRequestType());
        transactionResponse.setStatus("SUCCESS");

        return new ResponseEntity<>(transactionResponse,HttpStatus.CREATED);
    }
}
