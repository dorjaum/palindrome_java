package com.jmf.palindrome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.jmf.palindrome.config.PalindromeConfig;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ContextConfiguration(classes = PalindromeConfig.class, loader=AnnotationConfigContextLoader.class)
@ComponentScan(basePackages={"com.jmf.palindrome"})
public class Application {

	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) {
		context = SpringApplication.run(Application.class, args);
	}
	
	public static ConfigurableApplicationContext getContext(){
		return context;
	}
		
		
}
