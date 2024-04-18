package com.andrelake.desafiopicpaybackend.controllers;

import com.andrelake.desafiopicpaybackend.controllers.dtos.TransactionRequestDTO;
import com.andrelake.desafiopicpaybackend.controllers.dtos.TransactionResponseDTO;
import com.andrelake.desafiopicpaybackend.services.TransactionService;
import com.andrelake.desafiopicpaybackend.services.dtos.TransactionDTO;
import jakarta.validation.Valid;
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
    private TransactionService transactionService;


    @PostMapping("/create")
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody @Valid TransactionRequestDTO requestDTO) {
        TransactionDTO saved = transactionService.makeATransaction(new TransactionDTO(requestDTO));
        return new ResponseEntity<>(new TransactionResponseDTO(saved), HttpStatus.CREATED);
    }
}
