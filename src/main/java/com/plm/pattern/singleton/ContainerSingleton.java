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

    public static void registerInstance(String key, Object obj) throws Exception {
        if (map.containsKey(key)) throw new Exception("当前key已经有实例化对象了");
        map.put(key, obj);
    }

    public static Object getInstance(String key) throws Exception {
        if (!map.containsKey(key)) throw new Exception("当前key不存在实例化对象");
        return map.get(key);
    }
}
