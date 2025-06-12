package com.example.LoggingSystem.systemdesign;

public class ConsoleLogger implements ILogObserver{

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
