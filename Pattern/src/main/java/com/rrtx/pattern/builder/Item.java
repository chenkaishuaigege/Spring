package com.rrtx.pattern.builder;


/**
 * 创建一个表示食物条目的接口。
 */
public interface Item {

    public String name();
    public Packing packing();
    public float price();

}
