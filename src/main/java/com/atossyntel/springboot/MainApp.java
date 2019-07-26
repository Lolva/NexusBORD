package com.atossyntel.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.atossyntel.springboot.storage.StorageProperties;
import com.atossyntel.springboot.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MainApp {
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	
	// com.atossyntel.springboot.storage.FileSystemStorageService.java
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            storageService.init();
        };
    }
}

/*
 * @SpringBootApplication is a convenience annotation that adds all of the
 * following:
 * 
 * @Configuration tags the class as a source of bean definitions for the
 * application context.
 * 
 * @EnableAutoConfiguration tells Spring Boot to start adding beans based on
 * classpath settings, other beans, and various property settings.
 * 
 * Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot
 * adds it automatically when it sees spring-webmvc on the classpath. This flags
 * the application as a web application and activates key behaviors such as
 * setting up a DispatcherServlet.
 * 
 * @ComponentScan tells Spring to look for other components, configurations, and
 * services in the hello package, allowing it to find the controllers.
 */
