package com.study.create.factory;

public class ItalyFactory implements CoffeeShopFactory {
    @Override
    public Coffee createCoffee() {
        return new Cappuccino();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
