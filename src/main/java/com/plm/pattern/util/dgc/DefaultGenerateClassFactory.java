package com.plm.pattern.util.dgc;

import com.plm.pattern.proxy.myjdkproxy.MyJdkProxy;
import com.plm.pattern.util.dgc.wrapper.IDgcClassNameWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcFieldWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcImportPackageWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcMethodWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcPackageWrapper;
import com.plm.pattern.util.dgc.wrapper.myjdkproxy.DefaultClassNameWrapper;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2020/5/22
 */
public class DefaultGenerateClassFactory implements IGenerateClassAbstractFactory {

    private Object proxy; // 代理类
    private Class<?> proxyClass;

    private static DefaultGenerateClassFactory instance;

    private DefaultGenerateClassFactory(){ }

    public static DefaultGenerateClassFactory getInstance(Object proxy) {
        if (instance == null) {
            synchronized (DefaultGenerateClassFactory.class) {
                if (instance == null) {
                    instance = new DefaultGenerateClassFactory();
                }
            }
        }
        instance.proxy = proxy;
        instance.proxyClass = proxy.getClass();
        return instance;
    }

    @Override
    public IDgcPackageWrapper generatePackage() {
        return null;
    }

    @Override
    public List<IDgcImportPackageWrapper> generateImportPackages() {
        return null;
    }

    @Override
    public IDgcClassNameWrapper generateClassName() {
        return new DefaultClassNameWrapper(proxyClass.getPackage(), MyJdkProxy.class, proxyClass.getInterfaces());
    }

    @Override
    public List<IDgcFieldWrapper> generateFields() {
        return null;
    }

    @Override
    public List<IDgcMethodWrapper> generateMethods() {
        return null;
    }
}
