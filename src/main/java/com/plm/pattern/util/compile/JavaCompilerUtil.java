package com.plm.pattern.util.compile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.plm.pattern.util.exception.FileNotSupportException;

/**
 * Java编译器工具类
 * @author pankarl
 *
 */
public class JavaCompilerUtil {
	
	public static final String JAVA_FILE_SUFFIX_NAME = ".java"; // java文件的后缀名
	
	/**
	 * 把指定的.java文件编译成.class文件
	 * @param javaFile
	 * @throws IOException 
	 */
	public static void compile(File javaFile) throws IOException {
		// 文件不存在不做处理
		if (javaFile == null || !javaFile.exists()) throw new FileNotFoundException("需要编译的.java文件不存在");
		// 判断文件后缀名是否为.java文件，不是就不做处理
		if (!javaFile.getName().endsWith(JAVA_FILE_SUFFIX_NAME)) throw new FileNotSupportException("需要编译的文件不是Java文件");
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(javaFile);
		CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
		task.call();
		manager.close();
	}
}
