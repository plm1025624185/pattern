package com.plm.pattern.singleton;

/**
 * 双重检查模式
 * @author 潘磊明
 * @date 2020/5/19
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
