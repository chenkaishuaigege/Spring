package com.rrtx.pattern.builder;

public class CocaCola extends ColdDrink{


    @Override
    public String name() {
        return "可口可乐";
    }

    /**
     * 计算价格
     *
     * @return
     */
    @Override
    public float price() {
        return 3;
    }
}
