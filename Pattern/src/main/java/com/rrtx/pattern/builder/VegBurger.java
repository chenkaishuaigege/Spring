package com.rrtx.pattern.builder;

public class VegBurger extends Hamburger{

    @Override
    public String name() {
        return "蔬菜汉堡";
    }

    /**
     * 计算价格
     *
     * @return
     */
    @Override
    public float price() {
        return 12;
    }
}
