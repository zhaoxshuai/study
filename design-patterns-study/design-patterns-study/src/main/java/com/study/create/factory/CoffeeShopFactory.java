package com.study.create.factory;

/**
 * 咖啡店 抽象工厂
 */
public interface CoffeeShopFactory {

    //咖啡类
    Coffee createCoffee();

    //甜点类
    Dessert createDessert();
}
