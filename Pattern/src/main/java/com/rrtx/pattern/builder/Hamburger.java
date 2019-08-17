package com.rrtx.pattern.builder;

/**
 * 汉堡抽象类
 */
public abstract class Hamburger implements Item{

    /**
     * 打包
     * @return
     */
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    /**
     * 计算价格
     * @return
     */
    @Override
    public abstract float price();

}
