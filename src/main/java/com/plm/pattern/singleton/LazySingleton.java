package com.plm.pattern.singleton;

/**
 * 懒汉模式
 * @author 潘磊明
 * @date 2020/5/19
 */
public class LazySingleton {

    private static volatile LazySingleton singleton;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
