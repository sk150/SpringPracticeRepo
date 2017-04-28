package com.boot;

import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@SpringBootApplication
@Configuration
@ComponentScan(basePackages={"com"})
public class SpringWebServicesApp extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebServicesApp.class, args);
	}
	
	
	 @Override
	public Validator getValidator() {
		 final LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
	        factoryBean.setProviderClass(HibernateValidator.class);
	        return factoryBean;
	}

	/*@Bean
	    public Validator mvcValidator() {
	        final LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
	        factoryBean.setProviderClass(HibernateValidator.class);
	        return factoryBean;
	  }*/
	
}
