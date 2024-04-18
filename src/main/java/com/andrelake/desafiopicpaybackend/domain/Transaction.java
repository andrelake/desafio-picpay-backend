package com.andrelake.desafiopicpaybackend.domain;

import com.andrelake.desafiopicpaybackend.services.dtos.TransactionDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private User payee;

    public Transaction(User payer, BigDecimal amount,  User payee) {
        this.payer = payer;
        this.amount = amount;
        this.payee = payee;
        this.date = LocalDateTime.now();
    }
}
