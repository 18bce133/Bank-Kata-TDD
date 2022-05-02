package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryShould {

    public static final String currentDate = "12/05/2015";

    private TransactionRepository transactionRepository;
    @Mock
    private Clock clock;

    @BeforeEach
    public void initialiseRepository(){
        transactionRepository= new TransactionRepository();
    }

    @Test
    void deposit_Transaction()
    {
        when(clock.dateToString()).thenReturn(currentDate);
        transactionRepository.addDeposit(100);
        List<Transaction> transactions=transactionRepository.allTransactions();

        Assertions.assertEquals(1, transactions.size());
        Assertions.assertEquals(transactions.get(0),transaction(currentDate,100));
    }
    private Transaction transaction(String Date,int amount){
        return new Transaction(Date,amount);
    }
}
