package com.rrtx.pattern.builder;

public class MealBuilder {

    /**
     * 出餐:可口可乐+蔬菜汉堡
     */
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new CocaCola());
        return meal;
    }

    /**
     * 出餐:百事可乐+肌肉汉堡
     * @return
     */
    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new PepsiCola());
        return meal;
    }

}
