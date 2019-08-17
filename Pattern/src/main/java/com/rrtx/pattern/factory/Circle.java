package com.rrtx.pattern.factory;

/**
 * 创建工厂接口
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}
