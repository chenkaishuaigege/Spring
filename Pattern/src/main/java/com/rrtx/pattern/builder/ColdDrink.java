package com.rrtx.pattern.builder;

/**
 * 饮料抽象类
 */
public abstract class ColdDrink implements Item{

    /**
     * 打包方法
     * @return
     */
    @Override
    public Packing packing() {
        return new Bottle();
    }

    /**
     * 计算价格
     * @return
     */
    @Override
    public abstract float price();


}
