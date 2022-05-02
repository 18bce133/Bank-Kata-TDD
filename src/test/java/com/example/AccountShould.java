package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountShould {

    @Mock
    TransactionRepository transactionRepository;
    private Account account;
    @Mock
    private StatementPrinter statementPrinter;

    @BeforeEach
    private void initialiseAccount(){
        account=new Account(transactionRepository);
    }

    @Test
    public void deposit(){

        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void withdrawl(){
        account.withdraw(100);
        verify(transactionRepository).Withdrawal(100);
    }

    @Test
    public void statementPrint(){
        List<Transaction> transactions =asList(new Transaction());
        when(transactionRepository.allTransactions()).thenReturn(transactions);
        account.printStatement();
        verify(statementPrinter).print(transactions);

    }

}