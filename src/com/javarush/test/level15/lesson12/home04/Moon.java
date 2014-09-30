package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Reaktor on 30.09.2014.
 */
public final class Moon implements Planet{
    private static Moon _instance = null;

    private Moon() {}

    public static synchronized Moon getInstance() {
        if (_instance == null)
            _instance = new Moon();
        return _instance;
    }
}
