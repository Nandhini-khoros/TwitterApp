package com.example.Twitter;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TwitterappApplication {
	static{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.setProperty("current.date", dateFormat.format(new Date()));
	}
	static Logger logger = Logger.getLogger(TwitterappApplication.class);
	public static void main(String[] args) {
		logger.info("APP started");
		SpringApplication.run(TwitterappApplication.class, args);
	}

}
