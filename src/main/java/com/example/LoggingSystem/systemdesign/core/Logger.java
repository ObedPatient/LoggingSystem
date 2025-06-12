package com.example.LoggingSystem.systemdesign.core;

import com.example.LoggingSystem.systemdesign.chain.AbstractLogger;
import com.example.LoggingSystem.systemdesign.enums.LogTargetType;
import com.example.LoggingSystem.systemdesign.enums.LoggerLevel;
import com.example.LoggingSystem.systemdesign.manager.LogManager;
import com.example.LoggingSystem.systemdesign.target.LoggerTarget;

import java.util.Set;

public class Logger {
    private static Logger logger;
    private static AbstractLogger _chainOfLogger;
    private static LoggerTarget _loggerTarget;

    private Logger(Set<LogTargetType> targets) {
        if (logger != null) {
            throw new IllegalStateException("Logger has already been initialized");
        }
    }
    public static Logger getInstance(Set<LogTargetType> targets) {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger(targets);
                    _chainOfLogger = LogManager.doChaining();
                    _loggerTarget = LogManager.AddObservers(targets);
                }
            }
        }
        return logger;
    }

    public static Logger getInstance() {
        return getInstance(Set.of(LogTargetType.BOTH));
    }

    public void Info(String message){
        createLog(LoggerLevel.INFO, message);
    }
    public void Error(String message){
        createLog(LoggerLevel.ERROR, message);
    }

    public void Debug(String message){
        createLog(LoggerLevel.DEBUG, message);
    }

    private void createLog(LoggerLevel level, String message){
        _chainOfLogger.logMessage(level, message, _loggerTarget);
    }


}
