package com.example.LoggingSystem.systemdesign.chain;

import com.example.LoggingSystem.systemdesign.enums.LoggerLevel;
import com.example.LoggingSystem.systemdesign.target.LoggerTarget;

public class InfoLogger extends AbstractLogger {
    public InfoLogger(LoggerLevel level) {
        this.level = level;
    }

    @Override
    protected void display(LoggerLevel level, String message, LoggerTarget loggerTarget) {
        loggerTarget.notifyObservers(level, "INFO: "+ message);
    }
}
