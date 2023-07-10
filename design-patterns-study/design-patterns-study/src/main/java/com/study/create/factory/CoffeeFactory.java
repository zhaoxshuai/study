package com.study.create.factory;

/**
 * 工厂类
 */
public class CoffeeFactory {

    public Coffee create(String type){
        if ("americano".equals(type)){
            return new Americano();
        }
        if ("cappuccino".equals(type)){
            return new Cappuccino();
        }
        return null;
    }

}
