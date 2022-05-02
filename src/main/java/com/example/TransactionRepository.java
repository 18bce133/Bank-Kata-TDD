package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;


public class TransactionRepository {
    private final Clock clock;
    List<Transaction> transactions= new ArrayList<>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int i) {
        transactions.add(new Transaction(clock.dateToString(),i));
    }

    public void Withdrawal(int i){
        throw new UnsupportedOperationException();
    }

    public List<Transaction> allTransactions() {
        return unmodifiableList(transactions);
    }
}
