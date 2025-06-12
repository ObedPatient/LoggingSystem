package com.example.LoggingSystem.systemdesign;

public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(LoggerLevel level) {
        this.level = level;
    }


    @Override
    protected void display(LoggerLevel level,String message, LoggerTarget loggerTarget) {
        loggerTarget.notifyObservers(level, "ERROR: "+ message);
    }
}
