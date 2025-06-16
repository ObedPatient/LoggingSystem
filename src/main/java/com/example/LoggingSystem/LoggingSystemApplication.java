package com.example.LoggingSystem;

import com.example.LoggingSystem.systemdesign.core.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoggingSystemApplication.class, args);

		Logger logger = Logger.getInstance();

		logger.Info("Hello World This is Info Message");
		logger.Debug("Hello World This is Debug Message");
		logger.Error("Hello World This is Error Message");
	}



}
