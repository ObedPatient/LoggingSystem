package com.example.LoggingSystem.loggersystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Handler;

public class FileHandler extends AbstractLogHandler {
    private static final String FILE_PATH = "log.txt";

    @Override
    protected void processLog(LogLevel level, String source, String message) {
        try (FileWriter writer= new FileWriter(FILE_PATH, true)){
            writer.write(LogFormatter.format(level, source, message) + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
