package com.plm.pattern.factory.animal;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class Bird implements Animal {
    @Override
    public void name() {
        System.out.println("my name is bird");
    }

    @Override
    public void call() {
        System.out.println("bbbbbbbb");
    }
}
