package com.study.create.factory;

public class TestFacatoyMethod {

    public static void main(String[] args) throws Exception {
        //test basic factory method
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        coffeeFactory.create("cappuccino");

        //test static factory method
        StaticFactory.create(Americano.class);


        System.out.println("---------test abstract factory method----------");
        AmericanFactory americanFactory = new AmericanFactory();
        americanFactory.createCoffee();
        americanFactory.createDessert();
    }

}
