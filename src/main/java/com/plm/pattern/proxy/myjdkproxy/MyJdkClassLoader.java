package com.plm.pattern.proxy.myjdkproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyJdkClassLoader extends ClassLoader {
	
	private String classpath;
	
	public MyJdkClassLoader() {
		this.classpath = MyJdkProxy.class.getResource(".").getPath();
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classFilePath = this.classpath + name + ".class";
		File classFile = new File(classFilePath);
		if (!classFile.exists()) return null; // 如果没找到类文件，就返回null
		// 读取字节流，加载文件
		try(InputStream is = new FileInputStream(classFile);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
			byte[] cache = new byte[1024];
			int len = 0;
			while((len = is.read(cache)) != -1) {
				bos.write(cache, 0, len);
			}
			return defineClass(MyJdkProxy.class.getPackage().getName() + "." + name, bos.toByteArray(), 0, bos.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
}
