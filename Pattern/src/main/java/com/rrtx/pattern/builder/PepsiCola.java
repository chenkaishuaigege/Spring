package com.rrtx.pattern.builder;

public class PepsiCola extends ColdDrink{
    @Override
    public String name() {
        return "百事可乐";
    }

    /**
     * 计算价格
     *
     * @return
     */
    @Override
    public float price() {
        return 4;
    }
}
