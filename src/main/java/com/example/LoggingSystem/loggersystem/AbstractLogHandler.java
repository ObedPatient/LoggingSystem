package com.example.LoggingSystem.loggersystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractLogHandler {
    protected AbstractLogHandler nextHandler;

    protected static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public void setNext(AbstractLogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(LogLevel level, String source,String message) {
        executor.submit(() -> processLog(level, source, message));
        if (nextHandler != null) {
            nextHandler.handle(level, source, message);
        }
    }

    protected abstract void processLog(LogLevel level, String source, String message);

}
