package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {
    @Mock
    Print println;
    private List<Transaction> Transactions= Collections.EMPTY_LIST;

    @Test
    public void printHeader(){
        StatementPrinter statementPrinter=new StatementPrinter(println);
        statementPrinter.print(Transactions);
        verify(println).println("DATE | AMOUNT | BALANCE\n");
    }
    @Test
    void printTransaction(){
        StatementPrinter statementPrinter=new StatementPrinter(println);
        List <Transaction> transactions=new ArrayList<>();
        transactions.add(new Transaction("01/04/2014",1000));
        transactions.add(new Transaction("02/04/2014",-100));
        transactions.add(new Transaction("10/04/2014",500));


        statementPrinter.print(transactions);

        InOrder inOrder= Mockito.inOrder(println);
        inOrder.verify(println).println("DATE | AMOUNT | BALANCE\n");
        inOrder.verify(println).println("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(println).println("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(println).println("01/04/2014 | 1000.00 | 1000.00");


    }
}
