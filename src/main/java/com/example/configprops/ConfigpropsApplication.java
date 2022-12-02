package com.example.configprops;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

@SpringBootApplication
//@EnableConfigurationProperties(MyProperties.class)
public class ConfigpropsApplication {

    public static void main(String[] args)
    {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigpropsApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        System.out.println("environement=" + environment.getProperty("my-properties.host="));

        MyProperties bean = run.getBean(MyProperties.class);
        System.out.println("bean=" + bean);
    }

    // useful to print the content of the context spring application
    @Bean
    ApplicationRunner applicationRunner(List<MyProperties> myProperties) {
        return args -> {
            System.out.println(myProperties);
        };
    }

    @Bean
    @ConfigurationProperties(prefix = "my-properties")
    public MyProperties myProperties() {
        return new MyProperties();
    }

//    @Bean
//    @ConfigurationProperties(prefix = "some-properties")
//    public MyProperties someProperties() {
//        return new MyProperties();
//    }
}
