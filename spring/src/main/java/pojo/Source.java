package pojo;


public class Source {
    // 类型
    private String fruit;
    // 糖分描述
    private String sugar;
    // 大小杯
    private String size;


    /* setter and getter */
    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Source(String fruit, String sugar, String size) {
        this.fruit = fruit;
        this.sugar = sugar;
        this.size = size;
    }
}
