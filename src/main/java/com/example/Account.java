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
        transactionRepository.Withdrawl(money);

    }
    public void printStatement(){
        throw new UnsupportedOperationException();
    }
}
