package com.example.LoggingSystem.systemdesign;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileLogger implements ILogObserver{

    private final String logFile;

    public FileLogger() {
        this.logFile = "Obed.txt";
    }

    private String getLogDirectory(){
        // Format date as M-d-yyyy
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return today.format(formatter);
    }

    public void createLogDirectory(String logDirectory){
        try{
            Path dirPath = Paths.get(getLogDirectory());
            if(!Files.exists(dirPath)){
                Files.createDirectories(dirPath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error Creating log Directory" +e.getMessage());
        }
    }
    @Override
    public void log(String message) {
        System.out.println("FileLogger logging: " + message);
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
