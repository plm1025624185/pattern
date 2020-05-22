package com.plm.pattern.proxy.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * @author 潘磊明
 * @date 2020/5/21
 */
public class JdkDynamicHouseSale implements InvocationHandler {

    private Object proxyObj;

    public JdkDynamicHouseSale(){}

    /**
     * 获取代理实例
     * @param obj
     * @return
     */
    public Object getInstance(Object obj) {
        this.proxyObj = obj;
        Class<?> clazz = obj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object priceObj = method.invoke(proxyObj, args);
        if (!(priceObj instanceof Integer)) return priceObj; // 如果不是Integer类型不做处理
        Integer price = (Integer) priceObj;
        System.out.println("房子的原价格为：" + price.intValue() + "万");
        Integer proxyPrice = price + 5;
        System.out.println("通过代理后，房子的价格为：" + proxyPrice.intValue() + "万");
        return proxyPrice;
    }
}
