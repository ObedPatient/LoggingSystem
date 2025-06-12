package com.example.LoggingSystem.systemdesign;

public class InfoLogger extends AbstractLogger {
    public InfoLogger(LoggerLevel level) {
        this.level = level;
    }

    @Override
    protected void display(LoggerLevel level, String message, LoggerTarget loggerTarget) {
        loggerTarget.notifyObservers(level, "INFO: "+ message);
    }
}
