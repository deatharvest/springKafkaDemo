package com.example.kafka.message;

import java.io.Serializable;

/**
 * @author 江南
 * @usage
 * @reviewer
 * @since 2017/4/5
 */
public class ExampleMessage implements Serializable {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ExampleMessage(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public ExampleMessage() {
    }
}
