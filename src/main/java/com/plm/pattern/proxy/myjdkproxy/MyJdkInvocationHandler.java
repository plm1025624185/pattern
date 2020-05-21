package com.plm.pattern.proxy.myjdkproxy;

import java.lang.reflect.Method;

public interface MyJdkInvocationHandler {
	
	Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
