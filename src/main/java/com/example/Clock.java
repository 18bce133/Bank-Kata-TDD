package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String dateToString() {
        return localDate().format(dateTimeFormatter);
    }
    public LocalDate localDate(){
        return LocalDate.now();
    }
}
