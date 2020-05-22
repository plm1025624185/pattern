package com.plm.pattern.util.dgc.wrapper.myjdkproxy;

import com.plm.pattern.util.dgc.wrapper.IDgcFieldWrapper;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 潘磊明
 * @date 2020/5/22
 */
public class DefaultFieldWrapper implements IDgcFieldWrapper {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private Class<?> fieldClass;




    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getTypeName() {
        return null;
    }

    @Override
    public String getSimpleTypeName() {
        return null;
    }

    @Override
    public Set<String> listKeyWords() {
        return null;
    }
}
