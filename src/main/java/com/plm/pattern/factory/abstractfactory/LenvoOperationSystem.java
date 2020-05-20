package com.plm.pattern.factory.abstractfactory;

import com.plm.pattern.factory.IOperationSystem;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class LenvoOperationSystem implements IOperationSystem {
    @Override
    public void name() {
        System.out.println("联想的操作系统");
    }
}
