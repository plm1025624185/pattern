package com.plm.pattern.proxy.impl;

import com.plm.pattern.proxy.IHouseSale;

/**
 * @author 潘磊明
 * @date 2020/5/20
 */
public class StaticProxyHouseSale implements IHouseSale {

    private IHouseSale houseSale;

    public StaticProxyHouseSale(){}

    public StaticProxyHouseSale(IHouseSale houseSale) {
        this.houseSale = houseSale;
    }

    @Override
    public Integer saleHourse() {
        Integer oldPrice = houseSale.saleHourse();
        System.out.println("房子的原价格为：" + oldPrice.intValue() + "万");
        Integer newPrice = oldPrice + 1;
        System.out.println("通过代理后，房子价格为：" + newPrice.intValue() + "万");
        return newPrice;
    }
}
