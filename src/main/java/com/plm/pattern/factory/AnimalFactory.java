package com.plm.pattern.factory;

import com.plm.pattern.factory.animal.Animal;

/**
 * 工厂模式
 * @author 潘磊明
 * @date 2020/5/19
 */
public interface AnimalFactory {
    Animal createAnimal();
}
