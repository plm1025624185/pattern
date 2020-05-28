package com.plm.pattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器类单例模式
 * @author 潘磊明
 * @date 2020/5/19
 */
public class ContainerSingleton {
    private static Map<String, Object> map = new ConcurrentHashMap<>();

    private ContainerSingleton(){}

    public static Object getInstance(String key) throws Exception {
        Object instance = null;
        if (map.containsKey(key)) return map.get(key);
        instance = Class.forName(key).newInstance();
        map.put(key, instance);
        return instance;
    }
}
