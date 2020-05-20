package com.plm.pattern.factory.abstractfactory;

import com.plm.pattern.factory.ICpu;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class LenvoCpu implements ICpu {
    @Override
    public void name() {
        System.out.println("联想的CPU");
    }
}
