package com.kjetland;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class SomeBean {

    @Autowired
    private BeanB beanB;

    public void print() {
        Arrays.asList(1,2,3,4).stream()
                .map(i->i.toString())
                .map(s-> "Hello from SomeBean #" + s )
                .forEach(System.out::println);
    }
}
