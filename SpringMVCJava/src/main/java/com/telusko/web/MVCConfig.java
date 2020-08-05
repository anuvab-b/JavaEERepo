package com.telusko.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//Substitute for Dispatcher Servlet XML configuration.
@Configuration
@EnableWebMvc
@ComponentScan("com.telusko")
public class MVCConfig extends WebMvcConfigurerAdapter{
	
	
	
}
