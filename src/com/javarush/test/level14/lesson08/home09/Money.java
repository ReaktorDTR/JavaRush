package com.javarush.test.level14.lesson08.home09;

public abstract class Money {
    private double moneyAmount;

    public Money(double amount) {
        moneyAmount = amount;
    }

    public double getAmount() {
        return moneyAmount;
    }

    public abstract String getCurrencyName();
}

