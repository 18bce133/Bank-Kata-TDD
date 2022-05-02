package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;


public class PrintStatement {

    @Mock
    private Print print;

    @Test
    public void printAllTransactions(){

        verify(print).println("DATE | AMOUNT | BALANCE\n");
        verify(print).println("10/04/2014 | 500.00 | 1400.00\n");
        verify(print).println("02/04/2014 | -100.00 | 900.00\n");
        verify(print).println("01/04/2014 | 1000.00 | 1000.00\n");
    }
}
