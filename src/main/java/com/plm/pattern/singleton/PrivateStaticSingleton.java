package com.plm.pattern.singleton;

/**
 * 静态内部私有类模式
 * @author 潘磊明
 * @date 2020/5/19
 */
public class PrivateStaticSingleton {


    private PrivateStaticSingleton(){
        if (PrivateStaticSingletonSupport.singleton != null)
            throw new RuntimeException("实例已被初始化！");
    }

    public static PrivateStaticSingleton getInstance() {
        return PrivateStaticSingletonSupport.singleton;
    }

    private static class PrivateStaticSingletonSupport {
        private final static PrivateStaticSingleton singleton = new PrivateStaticSingleton();
    }
}
