package com.example;

public class Account {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int money){
        transactionRepository.addDeposit(money);

    }
    public void withdraw(int money){
        transactionRepository.Withdrawal(money);

    }
    public void printStatement(){
        statementPrinter.print(transactionRepository.allTransactions());
    }
}
