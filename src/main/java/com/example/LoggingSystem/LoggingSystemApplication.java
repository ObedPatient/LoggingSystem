package com.example.LoggingSystem;

import com.example.LoggingSystem.systemdesign.core.Logger;
import com.example.LoggingSystem.systemdesign.enums.LogTargetType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class LoggingSystemApplication {

	public static void main(String[] args) {

		//SpringApplication.run(LoggingSystemApplication.class, args);

//		Logger logger = Logger.getInstance();
		Logger logger = Logger.getInstance(Set.of(LogTargetType.FILE));

		logger.Info("test without FILE Log Hello World This is Info Message");
		logger.Debug("test without FILE Log Hello World This is Debug Message");
		logger.Error("test without FILE Log Hello World This is Error Message");
	}

}
