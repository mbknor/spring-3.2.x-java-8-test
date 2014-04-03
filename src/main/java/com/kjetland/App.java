package com.kjetland;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Just using some Java 8 features..." );

        Runnable a = () -> System.out.println("sss");
        a.run();


        print("---");
        List<Integer> l = Arrays.asList(1,2,3,4,5,6);
        l.stream()
                .map( (i) -> i.toString() )
                .forEach((s) -> print(s));

        print("---");
        Stream.builder().add(1).add(2).add(3).build()
                .map( (i) -> i.toString() )
                .forEach(App::print);

        print("---");
        Arrays.asList(1,2,3,4,5).stream()
                .filter( (i) -> i > 2 )
                .limit(2)
                .map( (i) -> i.toString() )
                .forEach(App::print);

        // Creating spring context and getting a Bean using Java 8 features
        // And since we're using @ComponentScan, spring is going to use
        // ASM. This will fail if using original Spring 3.2.8.RELEASE
        // But works when using the java 8 fixed version of spring
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SomeBean bean = ctx.getBean(SomeBean.class);
        bean.print();


    }

    public static void print(String s) {
        System.out.println(s);
    }
}
