package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StatementPrinterShould {
    @Mock
    Print println;
    private List<Transaction> Transactions= Collections.EMPTY_LIST;

    @Test
    public void printHeader(){

        StatementPrinter statementPrinter=new StatementPrinter();
        statementPrinter.print(Transactions);
        verify(println).println("DATE | AMOUNT | BALANCE");
    }
}
