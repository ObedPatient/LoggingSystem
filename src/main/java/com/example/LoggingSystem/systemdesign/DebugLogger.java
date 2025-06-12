package com.example.LoggingSystem.systemdesign;

public class DebugLogger extends AbstractLogger {
    public DebugLogger(LoggerLevel level) {
        this.level = level;
    }

    @Override
    protected void display(LoggerLevel level, String message, LoggerTarget loggerTarget) {
        loggerTarget.notifyObservers(level, "DEBUG: " + message);
    }
}
