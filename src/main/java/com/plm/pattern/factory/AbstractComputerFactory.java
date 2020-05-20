package com.plm.pattern.factory;

/**
 * 抽象工厂模式，定义产品族
 * @author 潘磊明
 * @date 2020/5/19
 */
public interface AbstractComputerFactory {
    ICpu createCpu();

    IOperationSystem createOperationSystem();
}
