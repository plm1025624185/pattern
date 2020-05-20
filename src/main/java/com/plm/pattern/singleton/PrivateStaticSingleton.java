package com.plm.pattern.singleton;

/**
 * 静态内部私有类模式
 * @author 潘磊明
 * @date 2020/5/19
 */
public class PrivateStaticSingleton {
    private PrivateStaticSingleton(){}

    public static PrivateStaticSingleton getInstance() {
        return PrivateStaticSingletonSupport.singleton;
    }

    private static class PrivateStaticSingletonSupport {
        private static PrivateStaticSingleton singleton = new PrivateStaticSingleton();
    }
}
