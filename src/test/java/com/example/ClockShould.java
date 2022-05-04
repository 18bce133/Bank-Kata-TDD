package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClockShould {

    @Test
    public void dateInDdMmYyyyFormat(){
        Clock clock=new Clock();
        String date=clock.dateToString();
        Assertions.assertEquals("24/04/2015", date);
    }
}
