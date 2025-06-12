package com.example.LoggingSystem.systemdesign.manager;

import com.example.LoggingSystem.systemdesign.chain.AbstractLogger;
import com.example.LoggingSystem.systemdesign.chain.DebugLogger;
import com.example.LoggingSystem.systemdesign.chain.ErrorLogger;
import com.example.LoggingSystem.systemdesign.chain.InfoLogger;
import com.example.LoggingSystem.systemdesign.enums.LogTargetType;
import com.example.LoggingSystem.systemdesign.enums.LoggerLevel;
import com.example.LoggingSystem.systemdesign.observer.ConsoleLogger;
import com.example.LoggingSystem.systemdesign.observer.FileLogger;
import com.example.LoggingSystem.systemdesign.target.LoggerTarget;
import java.util.Set;

public class LogManager {
    public static AbstractLogger doChaining(){
        AbstractLogger infoLogger = new InfoLogger(LoggerLevel.INFO);
        AbstractLogger debugLogger = new DebugLogger(LoggerLevel.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(LoggerLevel.ERROR);

        infoLogger.setNextLevelLogger(errorLogger);

        errorLogger.setNextLevelLogger(debugLogger);

        return infoLogger;
    }

    public static LoggerTarget AddObservers(Set<LogTargetType> targets) {
        LoggerTarget loggerTarget = new LoggerTarget();
        ConsoleLogger consoleLog = new ConsoleLogger();
        FileLogger fileLog = new FileLogger();

        boolean logToConsole = targets.contains(LogTargetType.CONSOLE) || targets.contains(LogTargetType.BOTH);
        boolean logToFile = targets.contains(LogTargetType.FILE) || targets.contains(LogTargetType.BOTH);

        if (logToConsole) {
            loggerTarget.addObserver(LoggerLevel.INFO, consoleLog);
            loggerTarget.addObserver(LoggerLevel.DEBUG, consoleLog);
            loggerTarget.addObserver(LoggerLevel.ERROR, consoleLog);
        }

        if (logToFile) {
            loggerTarget.addObserver(LoggerLevel.INFO, fileLog);
            loggerTarget.addObserver(LoggerLevel.DEBUG, fileLog);
            loggerTarget.addObserver(LoggerLevel.ERROR, fileLog);
        }

        return loggerTarget;
    }
}
