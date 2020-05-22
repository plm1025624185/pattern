package com.plm.pattern.proxy.myjdkproxy;


import java.lang.reflect.Method;

public class MyJdkProxy {

	protected MyJdkInvocationHandler handler;

	/**
	 * 生成新的代理实例
	 * @param classLoader
	 * @param interfaces
	 * @param handler
	 * @return
	 */
	public static Object newProxyInstance(MyJdkClassLoader classLoader, 
			Class<?>[] interfaces, MyJdkInvocationHandler handler) {
		// 步骤
		// 1.动态生成java文件

		// 2.将java文件写出到磁盘上

		// 3.编译java文件，生成.class文件

		// 4.把生成的java文件加载到JVM虚拟机中

		// 5.返回新的代理对象
		
		
		return null;
	}

}
