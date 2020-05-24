package com.plm.pattern.proxy.myjdkproxy;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.plm.pattern.proxy.IHouseSale;
import com.plm.pattern.util.compile.JavaCompilerUtil;
import com.plm.pattern.util.dgc.DefaultGenerateClassFactory;
import com.plm.pattern.util.dgc.IDgcProcess;
import com.plm.pattern.util.dgc.IGenerateClassAbstractFactory;
import com.plm.pattern.util.dgc.MyJdkProxyProcess;

public class MyJdkProxy {

	protected MyJdkInvocationHandler h;
	
	public MyJdkProxy(MyJdkInvocationHandler handler) {
		this.h = handler;
	}

	/**
	 * 生成新的代理实例
	 * @param classLoader
	 * @param interfaces
	 * @param handler
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws FileNotFoundException 
	 */
	public static Object newProxyInstance(MyJdkClassLoader classLoader, 
			Class<?>[] interfaces, MyJdkInvocationHandler handler) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 步骤
		// 1.动态生成java文件
		IGenerateClassAbstractFactory factory = DefaultGenerateClassFactory.getInstance(interfaces).builder();
		IDgcProcess dgcProcess = new MyJdkProxyProcess(factory);
		String java = dgcProcess.process();
		System.out.println(java);
		// 2.将java文件写出到磁盘上
		// 获取当前生成的代理类类名
		String proxyName = factory.generateClassName().getSimpleName();
		String proxyPath = MyJdkProxy.class.getResource(".").getPath();
		File javaFile = new File(proxyPath + proxyName + ".java");
		try (BufferedOutputStream javaOutputStream = new BufferedOutputStream(
				new FileOutputStream(javaFile));) {
			javaOutputStream.write(java.getBytes());
			javaOutputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 3.编译java文件，生成.class文件
		JavaCompilerUtil.compile(javaFile);
		// 4.把生成的java文件加载到JVM虚拟机中
		Class<?> proxyClass = classLoader.findClass(proxyName);
		// 获取构造文件
		Constructor<?> construct = proxyClass.getConstructor(MyJdkInvocationHandler.class);
		// 5.返回新的代理对象
		return construct.newInstance(handler);
	}

	public static void main(String[] args) throws IOException {
		IGenerateClassAbstractFactory factory = DefaultGenerateClassFactory.getInstance(new Class<?>[]{IHouseSale.class}).builder();
		IDgcProcess dgcProcess = new MyJdkProxyProcess(factory);
		String java = dgcProcess.process();
		System.out.println(java);
		String proxyName = factory.generateClassName().getSimpleName();
		String proxyPath = MyJdkProxy.class.getResource(".").getPath();
		File javaFile = new File(proxyPath + proxyName + ".java");
		try (BufferedOutputStream javaOutputStream = new BufferedOutputStream(
				new FileOutputStream(javaFile));) {
			javaOutputStream.write(java.getBytes());
			javaOutputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 3.编译java文件，生成.class文件
		JavaCompilerUtil.compile(javaFile);
	}
}
