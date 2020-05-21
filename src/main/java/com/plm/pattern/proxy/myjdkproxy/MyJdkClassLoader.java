package com.plm.pattern.proxy.myjdkproxy;

public class MyJdkClassLoader extends ClassLoader {

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		return null;
	}

	
	
	
}
