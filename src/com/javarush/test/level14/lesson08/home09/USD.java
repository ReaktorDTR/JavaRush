package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Reaktor on 29.09.2014.
 */
public class USD extends Money {
    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
