package com.plm.pattern.factory.factory;

import com.plm.pattern.factory.AnimalFactory;
import com.plm.pattern.factory.animal.Animal;
import com.plm.pattern.factory.animal.Cat;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
