package com.andrelake.desafiopicpaybackend.services.dtos;

import com.andrelake.desafiopicpaybackend.controllers.dtos.TransactionRequestDTO;
import com.andrelake.desafiopicpaybackend.domain.Transaction;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TransactionDTO {

    private Long id;
    @NotNull
    private Long payerId;
    @NotNull
    private Long payeeId;
    @NotNull @Min(value = 0)
    private BigDecimal amount;
    private LocalDateTime date;

    public TransactionDTO(@Valid TransactionRequestDTO requestDTO) {
        this.payerId = requestDTO.payerId();
        this.payeeId = requestDTO.payeeId();
        this.amount = requestDTO.amount();
        this.date = LocalDateTime.now();
    }

    public TransactionDTO(@Valid Transaction transaction) {
        this.id = transaction.getId();
        this.payerId = transaction.getPayer().getId();
        this.payeeId = transaction.getPayee().getId();
        this.amount = transaction.getAmount();
        this.date = transaction.getDate();
    }
}
