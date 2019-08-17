package com.rrtx.pattern.builder;

public class ChickenBurger extends Hamburger {


    @Override
    public String name() {
        return "肌肉汉堡";
    }

    /**
     * 计算价格
     *
     * @return
     */
    @Override
    public float price() {
        return 20;
    }
}
