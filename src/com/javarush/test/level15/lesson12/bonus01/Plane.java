package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Reaktor on 01.10.2014.
 */
public class Plane implements Flyable {
    private int pasenger;

    public Plane(int pasenger) {
        this.pasenger = pasenger;
    }

    @Override
    public void fly() {
    }
}
