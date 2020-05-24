package com.plm.pattern.proxy.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.plm.pattern.proxy.myjdkproxy.MyJdkClassLoader;
import com.plm.pattern.proxy.myjdkproxy.MyJdkInvocationHandler;
import com.plm.pattern.proxy.myjdkproxy.MyJdkProxy;

public class MyJdkProxyHouseSale implements MyJdkInvocationHandler {
	
	private Object proxyObj;

    /**
     * 获取代理实例
     * @param obj
     * @return
     * @throws IOException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws ClassNotFoundException 
     */
    public Object getInstance(Object obj) throws Exception {
        this.proxyObj = obj;
        Class<?> clazz = obj.getClass();
        return MyJdkProxy.newProxyInstance(new MyJdkClassLoader(), clazz.getInterfaces(), this);
    }

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object priceObj = method.invoke(this.proxyObj, args);
        if (!(priceObj instanceof Integer)) return priceObj; // 如果不是Integer类型不做处理
        Integer price = (Integer) priceObj;
        System.out.println("房子的原价格为：" + price.intValue() + "万");
        Integer proxyPrice = price + 5;
        System.out.println("通过代理后，房子的价格为：" + proxyPrice.intValue() + "万");
        after();
		return null;
	}
	
	private void before() {
		System.out.println("这是自己生成的动态代理before方法");
	}
	
	private void after() {
		System.out.println("这是自己生成的动态代理after方法");
	}

}
