package com.example.LoggingSystem.systemdesign.chain;

import com.example.LoggingSystem.systemdesign.enums.LoggerLevel;
import com.example.LoggingSystem.systemdesign.target.LoggerTarget;

public class DebugLogger extends AbstractLogger {
    public DebugLogger(LoggerLevel level) {
        this.level = level;
    }

    @Override
    protected void display(LoggerLevel level, String message, LoggerTarget loggerTarget) {
        loggerTarget.notifyObservers(level, "DEBUG: " + message);
    }
}
