package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PrintStatement {

    @Mock
    private Print print;

    private Account account;
    @Mock
    private Clock clock;

    @BeforeEach
    private void accountInitialise() {

        TransactionRepository transactionRepository=new TransactionRepository(clock);
        StatementPrinter statementPrinter=new StatementPrinter(print);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void printAllTransactions(){

        when(clock.dateToString()).thenReturn("01/04/2014","02/04/2014","10/04/2014");

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);
        account.printStatement();

        InOrder inOrder= Mockito.inOrder(print);
        inOrder.verify(print).println("DATE | AMOUNT | BALANCE\n");
        inOrder.verify(print).println("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(print).println("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(print).println("01/04/2014 | 1000.00 | 1000.00");
    }
}
