package com.andrelake.desafiopicpaybackend.controllers.dtos;

import com.andrelake.desafiopicpaybackend.services.dtos.TransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class TransactionResponseDTO {

    Long id;
    BigDecimal amount;
    String date;
    Long payerId;
    Long payeeId;


    public TransactionResponseDTO(TransactionDTO transactionDTO) {
        this.id = transactionDTO.getId();
        this.amount = transactionDTO.getAmount();
        this.date = transactionDTO.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.payerId = transactionDTO.getPayerId();
        this.payeeId = transactionDTO.getPayeeId();
    }
}
