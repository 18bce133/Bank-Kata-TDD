package com.example;

public class BankKataApplication {
    public static void main(String[] args) {
        Clock clock=new Clock();
        TransactionRepository transactionRepository=new TransactionRepository(clock);
        Print print=new Print();
        StatementPrinter statementPrinter=new StatementPrinter(print);
        Account account=new Account(transactionRepository,statementPrinter);
        account.deposit(1000);
        account.withdraw(400);
        account.deposit(100);
        account.printStatement();
    }
}
