package com.example.discount.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EarlyBirdDiscountService {
    public String calculateDiscount(LocalDate eventDate, LocalDate bookingDate){
        if(ChronoUnit.DAYS.between(eventDate,bookingDate) < 30){
            return "No discount";
        }else{
            return "You have 15% discount.";
        }
    }
}
