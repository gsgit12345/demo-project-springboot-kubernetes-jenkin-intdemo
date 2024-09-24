package com.tutorial.jenkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class DemoKubernetesJenkinApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(DemoKubernetesJenkinApp.class,args);
        System.out.println( "Hello World!" );
    }
}
