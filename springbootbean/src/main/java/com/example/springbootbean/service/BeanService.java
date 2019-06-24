package com.example.springbootbean.service;

import com.example.springbootbean.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service  // cho phép Spring có thể sử dụng @Autowire từ class khác gọi tới (Service Layer or Business Layer)
public class BeanService {
//    @Bean(name = "person2", initMethod = "init", destroyMethod = "destroy")
    @Bean(name = "person2")
    public Person person(){
        Person p = new Person("Phan Hai");
        return p;
    }

//    @Bean(name = "person1", initMethod = "init",destroyMethod = "destroy") // name: của các Bean phải khác nhau
    @Bean(name = "person1")
    @Qualifier("person1")  // để phân biết các Bean có cùng kiểu dữ liệu (Spring có thể dễ dàng xác định được Autowire tới bean nào
    public Person person1(){
        Person p = new Person("Hai");
        return p;
    }

//    @Bean(name = "person3", initMethod = "khoitao", destroyMethod = "cleanUp")
    @Bean(name = "person3")
    public Person person2(){
        Person p = new Person("Welcome come!");
        return p;
    }

    @Bean(name = "person4")
    public Person person3(){
        Person p = new Person("Welcome to Vietnam");
        return p;
    }

    @Bean(name="hello")
    @Qualifier("world")
    public String name(){
        return "Hello World!";
    }

    @Bean
    public String mail(){
        return "Zero Mail";
    }
}
