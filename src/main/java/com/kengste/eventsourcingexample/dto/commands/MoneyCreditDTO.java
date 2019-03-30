package com.kengste.eventsourcingexample.dto.commands;

public class MoneyCreditDTO {

    private double creditAmount;
    private String currency;

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

// Different DTO objects serve as payloads for different commands