package com.plm.pattern.factory;

import com.plm.pattern.factory.abstractfactory.LenvoComputerFactory;
import com.plm.pattern.factory.animal.Animal;
import com.plm.pattern.factory.factory.BirdFactory;
import com.plm.pattern.factory.factory.CatFactory;
import com.plm.pattern.factory.factory.DogFactory;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class Test {
    public static void main(String[] args) {
        // 简单工厂模式
//        Animal dog = SimpleFactory.createAnimal("dog");
//        Animal cat = SimpleFactory.createAnimal("cat");
//        Animal bird = SimpleFactory.createAnimal("bird");
//        dog.name();
//        cat.name();
//        bird.name();

        // 工厂模式
//        Animal dog = new DogFactory().createAnimal();
//        Animal cat = new CatFactory().createAnimal();
//        Animal bird = new BirdFactory().createAnimal();
//        dog.name();
//        cat.name();
//        bird.name();

        // 抽象工厂模式
        AbstractComputerFactory factory = new LenvoComputerFactory();
        ICpu cpu = factory.createCpu();
        IOperationSystem os = factory.createOperationSystem();
        cpu.name();
        os.name();
    }
}
