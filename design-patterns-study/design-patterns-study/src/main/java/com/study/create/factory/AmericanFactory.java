package com.study.create.factory;

/**
 * 美式风格工厂
 */
public class AmericanFactory implements CoffeeShopFactory{
    @Override
    public Coffee createCoffee() {
        return new Americano();
    }

    @Override
    public Dessert createDessert() {
        return new Cheesecake();
    }
}
