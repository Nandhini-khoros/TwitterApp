package com.example.Twitter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
@EnableCaching
public class TwitterappApplication  {
	public static void main(String[] args) {
		SpringApplication.run(TwitterappApplication.class, args);
	}
}

