package com.plm.pattern.util.dgc.wrapper.myjdkproxy;

import com.plm.pattern.util.dgc.wrapper.IDgcFieldWrapper;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 潘磊明
 * @date 2020/5/22
 */
public class DefaultFieldWrapper implements IDgcFieldWrapper {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    
    private final static String NAME = "m";

    private Method field; // 接口需要代理的方法
//    private Class<?>[] interfaces; //接口类
    private int currentIndex; 

    public DefaultFieldWrapper(Method field) {
    	this.field = field;
//    	this.interfaces = interfaces;
    	this.currentIndex = atomicInteger.getAndIncrement();
	}


    @Override
    public String getName() {
        return NAME + this.currentIndex;
    }

    @Override
    public String getTypeName() {
        return field.getClass().getName();
    }

    @Override
    public String getSimpleTypeName() {
        return field.getClass().getSimpleName();
    }

    @Override
    public Set<String> listKeyWords() {
        return new LinkedHashSet<>(Arrays.asList("static"));
    }
    
//    public Class<?>[] getInvokeInterfaces() {
//    	return interfaces;
//    }
    
    public Method getMethod() {
    	return field;
    }
}
