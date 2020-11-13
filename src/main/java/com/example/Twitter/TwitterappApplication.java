package com.example.Twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

@SpringBootApplication

public class TwitterappApplication  {



	public static void main(String[] args) {
		SpringApplication.run(TwitterappApplication.class, args);


	}
}

