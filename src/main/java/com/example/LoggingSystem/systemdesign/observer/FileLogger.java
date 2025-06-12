package com.example.LoggingSystem.systemdesign.observer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileLogger implements ILogObserver {

    private final String logFile;

    public FileLogger() {
        this.logFile = "application.txt";
    }

    private String getLogDirectory() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        return Paths.get(
                "logs",                        // Root logs directory
                String.valueOf(year),         // Year folder
                String.format("%02d", month), // Month folder (e.g., "06")
                String.format("%02d", day)    // Day folder (e.g., "12")
        ).toString();
    }

    public void createLogDirectory(String logDirectory){
        try {
            Path dirPath = Paths.get(logDirectory);
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error Creating log Directory: " + e.getMessage());
        }
    }

    @Override
    public void log(String message) {
        String logDirectory = getLogDirectory();
        createLogDirectory(logDirectory);
        String logFilePath = logDirectory + "/" + logFile;
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            writer.println(message);
        } catch (IOException e){
            System.out.println("Error writing to log file" + e.getMessage());
        }
    }
}
