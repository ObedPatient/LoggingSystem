package com.example.LoggingSystem.systemdesign.target;

import com.example.LoggingSystem.systemdesign.enums.LoggerLevel;
import com.example.LoggingSystem.systemdesign.observer.ILogObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerTarget {

    private final Map<LoggerLevel, List<ILogObserver>> logObservers = new ConcurrentHashMap<>();

    public void addObserver(LoggerLevel level, ILogObserver observer) {
        logObservers.computeIfAbsent(level, k -> Collections.synchronizedList(new ArrayList<>())).add(observer);
    }

    public void removeObserver(LoggerLevel level, ILogObserver observer) {
        logObservers.values().forEach(list -> list.remove(observer));
    }

    public void notifyObservers(LoggerLevel level, String message){
        List<ILogObserver> observers = logObservers.get(level);
        if(observers != null){
            for(ILogObserver observer : observers){
                observer.log(message);
            }
        }
    }
}
