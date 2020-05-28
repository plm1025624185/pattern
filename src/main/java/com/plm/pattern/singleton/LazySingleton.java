package com.plm.pattern.singleton;

/**
 * 懒汉模式
 * @author 潘磊明
 * @date 2020/5/28
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
