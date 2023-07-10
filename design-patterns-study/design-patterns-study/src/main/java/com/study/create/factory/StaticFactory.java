package com.study.create.factory;

/**
 * 使用反射创建对象
 * 加一个static变为静态工程
 */
public class StaticFactory {

    public static Coffee create(Class<? extends Coffee> clazz) throws Exception {
        if (clazz != null){
            return clazz.newInstance();
        }
        return null;
    }

}
