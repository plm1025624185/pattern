package com.plm.pattern.factory;

import com.plm.pattern.factory.animal.Animal;
import com.plm.pattern.factory.animal.Bird;
import com.plm.pattern.factory.animal.Cat;
import com.plm.pattern.factory.animal.Dog;

import java.util.concurrent.CountDownLatch;

/**
 * 简单工厂模式
 * @author 潘磊明
 * @date 2020/5/19
 */
public class SimpleFactory {
    public static Animal createAnimal(String animalName) {
        switch (animalName) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
            case "bird":
                return new Bird();
                default:
                    return null;
        }
    }
}
