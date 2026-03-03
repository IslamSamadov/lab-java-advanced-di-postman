package com.example.discount.controller;

import com.example.discount.service.EarlyBirdDiscountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
    private EarlyBirdDiscountService service;

    public DiscountController(Optional<EarlyBirdDiscountService> service){
        this.service = service.orElse(null);
    }

    @GetMapping
    public String discount(@RequestParam String eventDate, @RequestParam String bookingDate){
        if (service == null){
            return "Early bird discount is diabled";
        }
        return service.calculateDiscount(LocalDate.parse(eventDate),LocalDate.parse(bookingDate));
    }
}
