package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;


public class PrintStatement {

    @Mock
    private Print print;

    private Account account;
    @BeforeEach
    private void accountInitialise() {
        TransactionRepository transactionRepository=new TransactionRepository();
        account = new Account(transactionRepository);
    }

    @Test
    public void printAllTransactions(){

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);
        account.printStatement();

        InOrder inOrder= Mockito.inOrder(print);
        inOrder.verify(print).println("DATE | AMOUNT | BALANCE\n");
        inOrder.verify(print).println("10/04/2014 | 500.00 | 1400.00\n");
        inOrder.verify(print).println("02/04/2014 | -100.00 | 900.00\n");
        inOrder.verify(print).println("01/04/2014 | 1000.00 | 1000.00\n");
    }
}
