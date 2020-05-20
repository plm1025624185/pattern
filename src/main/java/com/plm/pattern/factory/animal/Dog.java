package com.plm.pattern.factory.animal;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class Dog implements Animal {
    @Override
    public void name() {
        System.out.println("my name is dog");
    }

    @Override
    public void call() {
        System.out.println("wang wang wang");
    }
}
