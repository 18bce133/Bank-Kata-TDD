package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class AccountShould {

    private TransactionRepository transactionRepository;
    @Test
    public void deposit(){
        verify(transactionRepository).addDeposit(100);
    }

}