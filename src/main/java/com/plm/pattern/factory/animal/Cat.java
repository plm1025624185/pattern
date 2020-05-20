package com.plm.pattern.factory.animal;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class Cat implements Animal {
    @Override
    public void name() {
        System.out.println("my name is cat");
    }

    @Override
    public void call() {
        System.out.println("miao miao miao");
    }
}
