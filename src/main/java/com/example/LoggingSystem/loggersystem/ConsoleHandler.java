package com.example.LoggingSystem.loggersystem;

public class ConsoleHandler extends AbstractLogHandler{

    @Override
    protected  void processLog(LogLevel level, String source, String message){
        System.out.println(LogFormatter.format(level, source, message));
    }
}
