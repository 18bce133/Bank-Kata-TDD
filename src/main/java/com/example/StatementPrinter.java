package com.example;

import java.util.List;

public class StatementPrinter {
    public static final String HEADER = "DATE | AMOUNT | BALANCE";
    private Print print;

    public StatementPrinter(Print print) {
        this.print = print;
    }

    public void print(List<Transaction> transactions) {
        print.println(HEADER)
        ;
    }
}
