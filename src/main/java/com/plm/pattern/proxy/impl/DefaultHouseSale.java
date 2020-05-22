package com.plm.pattern.proxy.impl;

import com.plm.pattern.proxy.IHouseSale;

import java.util.Random;

/**
 * @author 潘磊明
 * @date 2020/5/20
 */
public class DefaultHouseSale implements IHouseSale {
    @Override
    public Integer saleHourse() {
        Random random = new Random();
        return random.nextInt(100);
        System.arraycopy();
    }
}
