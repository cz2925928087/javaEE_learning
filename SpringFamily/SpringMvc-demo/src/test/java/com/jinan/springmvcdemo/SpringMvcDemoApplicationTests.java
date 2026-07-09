package com.jinan.springmvcdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tools.jackson.databind.ObjectMapper;

import java.lang.runtime.ObjectMethods;

@SpringBootTest
class SpringMvcDemoApplicationTests {

    @Test
    void contextLoads() {

        ObjectMapper objectMapper = new ObjectMapper();
        //对象转JSON
        Person person = new Person();
        person.setName("瑾桉");
        person.setAge(20);
        person.setGender(1);
        person.setEmail("2925@126.com");
        String jsonStr = objectMapper.writeValueAsString(person);
        System.out.println(jsonStr);


        //json转对象
        Person p = objectMapper.readValue(jsonStr, Person.class);
        System.out.println(p.toString());

    }

}
