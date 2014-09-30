package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Reaktor on 30.09.2014.
 */
public final class Sun implements Planet {
    private static Sun _instance = null;

    private Sun() {}

    public static synchronized Sun getInstance() {
        if (_instance == null)
            _instance = new Sun();
        return _instance;
    }
}
