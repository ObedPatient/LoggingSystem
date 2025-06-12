package com.example.LoggingSystem.systemdesign;

public abstract class AbstractLogger {
    protected LoggerLevel level;

    private AbstractLogger nextLevelLogger;

    public void setNextLevelLogger(AbstractLogger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(LoggerLevel level, String message, LoggerTarget loggerTarget ) {
        if(this.level == level){
            display(level, message, loggerTarget);
        }

        if(nextLevelLogger != null){
            nextLevelLogger.logMessage(level, message, loggerTarget);
        }
    }


    protected abstract void display(LoggerLevel level, String message, LoggerTarget loggerTarget);
}
