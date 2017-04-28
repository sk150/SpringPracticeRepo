package com.practice;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
//@ImportResource("read-integration-context.xml")
@ImportResource("ftp-integration-context.xml")
//@ImportResource("local-integration-context.xml")
public class SpringIntegrationFtpApplication implements ApplicationRunner {

	public void run(ApplicationArguments arg0) throws InterruptedException, ExecutionException {
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationFtpApplication.class, args);
	}

}
