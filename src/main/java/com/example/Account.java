package com.example;

public class Account {
    private TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int money){
        transactionRepository.addDeposit(money);

    }
    public void withdraw(int money){
        throw new UnsupportedOperationException();

    }
    public void printStatement(){
        throw new UnsupportedOperationException();
    }
}
