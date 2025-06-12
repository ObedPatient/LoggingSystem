package com.example.LoggingSystem.systemdesign;

public enum LoggerLevel {
    INFO(1), DEBUG(2), ERROR(3);

    private int level;

    LoggerLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public boolean isAtLeast(LoggerLevel level) {
        return this.level >= level.getLevel();
    }
}
