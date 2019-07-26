package pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "message")
public class Message {

    @Value("chenkai")
    String name;

    @Value("1")
    int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
