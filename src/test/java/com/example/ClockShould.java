package com.example;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ClockShould {

    @Test
    public void dateInDdMmYyyyFormat(){
        Clock clock=new TestClock();
        String date=clock.dateToString();
        Assertions.assertEquals("03/05/2022", date);
    }

    private class TestClock extends Clock{
        @Override
        public LocalDate localDate(){
            return LocalDate.of(2022, 5, 3);
        }
    }
}
