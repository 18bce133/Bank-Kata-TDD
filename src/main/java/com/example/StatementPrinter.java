package com.example;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.collect.Lists.reverse;
import static java.util.stream.Collectors.toList;

public class StatementPrinter {
    public static final String HEADER = "DATE | AMOUNT | BALANCE\n";
    private Print print;

    public StatementPrinter(Print print) {
        this.print = print;
    }

    public void print(List<Transaction> transactions) {
        print.println(HEADER);
        printStatementLinesFor(transactions);

    }
    private void printStatementLinesFor(List<Transaction> transactionList) {
        List<String> statementLines = statementLines(transactionList);
        reverse(statementLines).forEach(print::println);
    }

    private List<String> statementLines(List<Transaction> transactionList) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        return transactionList
                .stream()
                .map(transaction -> statementLine(runningBalance, transaction))
                .collect(toList());
    }

    private String statementLine(AtomicInteger runningBalance, Transaction t) {
        return t.getDate() +
                " | " +
                formatDecimal(t.getAmount()) +
                " | " +
                formatDecimal(runningBalance.addAndGet(t.getAmount()));
    }

    private String formatDecimal(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(amount);
    }
}

