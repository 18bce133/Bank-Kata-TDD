package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountShould {

    @Mock
    TransactionRepository transactionRepository;

    private Account account;
    @Mock
    private StatementPrinter statementPrinter;

    @BeforeEach
    private void initialiseAccount(){
        account=new Account(transactionRepository,statementPrinter);
    }

    @Test
    void deposit(){

        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }

    @Test
    void withdrawl(){
        account.withdraw(100);
        verify(transactionRepository).Withdrawal(100);
    }

    @Test
    void statementPrint(){
        List<Transaction> transactions =asList(new Transaction());
        when(transactionRepository.allTransactions()).thenReturn(transactions);
        account.printStatement();
        verify(statementPrinter).print(transactions);

    }

}