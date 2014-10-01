package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Reaktor on 01.10.2014.
 */
public abstract class DrinkMaker {
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();
    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
