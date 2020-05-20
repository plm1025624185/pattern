package com.plm.pattern.factory.factory;

import com.plm.pattern.factory.AnimalFactory;
import com.plm.pattern.factory.animal.Animal;
import com.plm.pattern.factory.animal.Dog;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
