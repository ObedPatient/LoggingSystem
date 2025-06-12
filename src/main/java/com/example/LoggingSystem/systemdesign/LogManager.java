package com.example.LoggingSystem.systemdesign;

public class LogManager {
    public static AbstractLogger doChaining(){
        AbstractLogger infoLogger = new InfoLogger(LoggerLevel.INFO);
        AbstractLogger debugLogger = new DebugLogger(LoggerLevel.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(LoggerLevel.ERROR);

        infoLogger.setNextLevelLogger(errorLogger);

        errorLogger.setNextLevelLogger(debugLogger);

        return infoLogger;
    }

    public static LoggerTarget AddObservers(){
        LoggerTarget loggerTarget = new LoggerTarget();
        ConsoleLogger consoleLog = new ConsoleLogger();

        loggerTarget.addObserver(LoggerLevel.INFO, consoleLog);
        loggerTarget.addObserver(LoggerLevel.DEBUG, consoleLog);
        loggerTarget.addObserver(LoggerLevel.ERROR, consoleLog);

        FileLogger fileLog = new FileLogger();

        loggerTarget.addObserver(LoggerLevel.INFO, fileLog);
        loggerTarget.addObserver(LoggerLevel.DEBUG, fileLog);
        loggerTarget.addObserver(LoggerLevel.ERROR, fileLog);

        return loggerTarget;
    }
}
