package com.jmf.palindrome.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.jmf")
@EnableTransactionManagement
public class PalindromeConfig {

	
}
