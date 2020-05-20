package com.plm.pattern.singleton;

import java.io.Serializable;

/**
 * 饿汉模式
 * @author 潘磊明
 * @date 2020/5/19
 */
public class HungrySingleton implements Serializable {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * 防止被对象流序列化而打破单例
     * @return
     */
    private Object readResolve(){return hungrySingleton;}
}
