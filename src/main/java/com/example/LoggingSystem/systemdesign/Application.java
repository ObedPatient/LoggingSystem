package com.example.LoggingSystem.systemdesign;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.Info("Hello World This is Info Message");
        logger.Debug("Hello World This is Debug Message");
        logger.Error("Hello World This is Error Message");
    }
}
