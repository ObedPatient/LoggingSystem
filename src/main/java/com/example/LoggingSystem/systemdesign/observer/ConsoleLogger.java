package com.example.LoggingSystem.systemdesign.observer;

public class ConsoleLogger implements ILogObserver {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
