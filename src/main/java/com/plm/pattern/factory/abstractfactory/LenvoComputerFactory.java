package com.plm.pattern.factory.abstractfactory;

import com.plm.pattern.factory.AbstractComputerFactory;
import com.plm.pattern.factory.ICpu;
import com.plm.pattern.factory.IOperationSystem;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class LenvoComputerFactory implements AbstractComputerFactory {
    @Override
    public ICpu createCpu() {
        return new LenvoCpu();
    }

    @Override
    public IOperationSystem createOperationSystem() {
        return new LenvoOperationSystem();
    }
}
