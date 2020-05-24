package com.plm.pattern.util.dgc.wrapper.myjdkproxy;

import com.plm.pattern.util.dgc.wrapper.IDgcClassNameWrapper;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 潘磊明
 * @date 2020/5/22
 */
public class DefaultClassNameWrapper implements IDgcClassNameWrapper {

    public  final static String NAME = "$Proxy";

    private static AtomicInteger index = new AtomicInteger(0); // 索引缓存

    private int currentIndex; // 当前索引

    private Package packageClass; // 包类

    private Class<?> extendsClass; // 继承的类

    private Class<?>[] interfacesClasses; // 实现的接口类

    public DefaultClassNameWrapper(Package packageClass, Class<?> extendsClass, Class<?>[] interfacesClass) {
        this.packageClass = packageClass;
        this.extendsClass = extendsClass;
        this.interfacesClasses = interfacesClass;
        this.currentIndex = index.getAndIncrement();
    }


    @Override
    public String getSimpleName() {
        return NAME + currentIndex;
    }

    @Override
    public String getName() {
        return packageClass.getName() + "." + getSimpleName();
    }

    @Override
    public String getExtendsSimpleName() {
        return extendsClass.getSimpleName();
    }

    @Override
    public String getExtendsName() {
        return extendsClass.getName();
    }

    /**
     * 需要注意类名有重复的，第一个不用处理，以后的直接应用类全名
     * @return
     */
    @Override
    public Set<String> listInterfacesSimpleNames() {
        Set<String> set = new LinkedHashSet<>();
        for (Class<?> clazz : interfacesClasses) {
            if (set.contains(clazz.getSimpleName())) set.add(clazz.getName());
            else set.add(clazz.getSimpleName());
        }
        return set;
    }

    @Override
    public Set<String> listInterfacesNames() {
        Set<String> set = new LinkedHashSet<>();
        for (Class<?> clazz : interfacesClasses) { set.add(clazz.getName()); }
        return set;
    }

    @Override
    public Set<String> listKeyWords() {
        Set<String> set = new LinkedHashSet<>(Arrays.asList("final"));
        return set;
    }
}
