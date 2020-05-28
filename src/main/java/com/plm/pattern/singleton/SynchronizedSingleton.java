package com.plm.pattern.singleton;

/**
 * @author 潘磊明
 * @date 2020/5/28
 */
public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton(){}

    public synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
