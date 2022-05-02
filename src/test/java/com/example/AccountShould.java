package com.example;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class AccountShould {

    @Mock
    TransactionRepository transactionRepository;
    private Account account;

    @BeforeEach
    private void initialiseAccount(){
        account=new Account(transactionRepository);
    }

    @Test
    public void deposit(){
        account.deposit(100);

        verify(transactionRepository).addDeposit(100);
    }

}