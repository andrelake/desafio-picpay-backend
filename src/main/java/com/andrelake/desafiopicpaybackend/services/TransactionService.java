package com.andrelake.desafiopicpaybackend.services;

import com.andrelake.desafiopicpaybackend.domain.Transaction;
import com.andrelake.desafiopicpaybackend.domain.User;
import com.andrelake.desafiopicpaybackend.domain.enums.UserType;
import com.andrelake.desafiopicpaybackend.exceptions.BusinessException;
import com.andrelake.desafiopicpaybackend.exceptions.InsufficientBalanceException;
import com.andrelake.desafiopicpaybackend.repositories.TransactionRepository;
import com.andrelake.desafiopicpaybackend.services.dtos.TransactionDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public TransactionDTO makeATransaction(@Valid TransactionDTO transaction) {
        Transaction savedTransaction;
        User payer = userService.findById(transaction.getPayerId());
        User payee = userService.findById(transaction.getPayeeId());

        if(isASelfDeposit(payer, payee)) {
            payer.setBalance(payer.getBalance().add(transaction.getAmount()));
            userService.save(payer);
            savedTransaction = transactionRepository.save(new Transaction(payer, transaction.getAmount(), payee));
        } else {
            validateTransaction(payer, transaction);
            savedTransaction = transactionHandler(payer, payee, transaction.getAmount());
        }

        return new TransactionDTO(savedTransaction);
    }

    private boolean isASelfDeposit(User payer, User payee) {
        return payer.getId().equals(payee.getId());
    }

    @Transactional
    private Transaction transactionHandler(@Valid User payer, User payee, BigDecimal amount) {
        payer.setBalance(payer.getBalance().subtract(amount));
        payee.setBalance(payee.getBalance().add(amount));

        userService.save(payer);
        userService.save(payee);

        return transactionRepository.save(new Transaction(payer, amount, payee));
    }

    private void validateTransaction(User payer, TransactionDTO transaction) {
        if (payer.getUserType().equals(UserType.SHOPKEEPER))
            throw new BusinessException("Error - Shopkeeper can't make transactions");

        if (payer.getBalance().compareTo(transaction.getAmount()) < 0)
            throw new InsufficientBalanceException("Error - Insufficient balance");
    }
}
