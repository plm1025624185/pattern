package com.plm.pattern.util.dgc;

import com.plm.pattern.proxy.myjdkproxy.MyJdkProxy;
import com.plm.pattern.util.dgc.wrapper.IDgcClassNameWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcConstructMethodWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcFieldWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcImportPackageWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcMethodWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcPackageWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcStaticWrapper;
import com.plm.pattern.util.dgc.wrapper.myjdkproxy.DefaultClassNameWrapper;
import com.plm.pattern.util.dgc.wrapper.myjdkproxy.DefaultConstructWrapper;
import com.plm.pattern.util.dgc.wrapper.myjdkproxy.DefaultFieldWrapper;
import com.plm.pattern.util.dgc.wrapper.myjdkproxy.DefaultImportPackageWrapper;
import com.plm.pattern.util.dgc.wrapper.myjdkproxy.DefaultMethodWrapper;
import com.plm.pattern.util.dgc.wrapper.myjdkproxy.DefaultPackageWrapper;
import com.plm.pattern.util.dgc.wrapper.myjdkproxy.DefaultStaticWrapper;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 潘磊明
 * @date 2020/5/22
 */
public class DefaultGenerateClassFactory implements IGenerateClassAbstractFactory {

    private Class<?>[] interfaces;
    
    private DefaultPackageWrapper defaultPackageWrapper;
    private DefaultClassNameWrapper defaultClassNameWrapper;
    private List<DefaultFieldWrapper> fieldList; 
    private List<DefaultMethodWrapper> methodList;
    private DefaultStaticWrapper staticWrapper;
    private List<DefaultConstructWrapper> constructList;
    private DefaultImportPackageWrapper importPackage;

    private static DefaultGenerateClassFactory instance;

    private DefaultGenerateClassFactory(){ }

    public static DefaultGenerateClassFactory getInstance(Class<?>[] interfaces) {
        if (instance == null) {
            synchronized (DefaultGenerateClassFactory.class) {
                if (instance == null) {
                    instance = new DefaultGenerateClassFactory();
                }
            }
        }
        instance.interfaces = interfaces;
        return instance;
    }
    
    public DefaultGenerateClassFactory builder() {
    	// 包
    	this.defaultPackageWrapper = new DefaultPackageWrapper(MyJdkProxy.class);
    	// 类名
    	this.defaultClassNameWrapper = new DefaultClassNameWrapper(MyJdkProxy.class.getPackage(), 
    			MyJdkProxy.class, interfaces);
    	// 属性
    	List<DefaultFieldWrapper> fieldList = new LinkedList<>();
    	for (int i = 0; i < interfaces.length; i++) {
    		Class<?> inter = interfaces[i];
    		Method[] methods = inter.getMethods();
    		for (int j = 0; j < methods.length; j++) {
    			fieldList.add(new DefaultFieldWrapper(methods[j]));
    		}
    	}
    	this.fieldList = fieldList;
    	// 方法
    	this.methodList = this.fieldList.stream()
    			.map(e -> new DefaultMethodWrapper(e)).collect(Collectors.toList());
    	// 静态块
    	this.staticWrapper = new DefaultStaticWrapper(this.fieldList);
    	// 构造方法
    	this.constructList = Arrays.asList(new DefaultConstructWrapper(this.defaultClassNameWrapper));
    	// import方法
    	this.importPackage = new DefaultImportPackageWrapper(this.interfaces, this.fieldList, this.methodList);
    	return this;
    }

    @Override
    public IDgcPackageWrapper generatePackage() {
        return this.defaultPackageWrapper;
    }

    @Override
    public IDgcImportPackageWrapper generateImportPackage() {
        return this.importPackage;
    }

    @Override
    public IDgcClassNameWrapper generateClassName() {
        return this.defaultClassNameWrapper;
    }

    @Override
    public List<? extends IDgcFieldWrapper> generateFields() {
        return this.fieldList;
    }

    @Override
    public List<? extends IDgcMethodWrapper> generateMethods() {
        return this.methodList;
    }

	@Override
	public List<? extends IDgcConstructMethodWrapper> generateConstructMethods() {
		return this.constructList;
	}

	@Override
	public IDgcStaticWrapper generateStaticMethods() {
		return this.staticWrapper;
	}
}
