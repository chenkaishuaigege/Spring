package pojo;

import org.springframework.beans.factory.annotation.Required;

public class Student3 {

    private Integer age;
    private String name;

    @Required
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
