package com.example.LoggingSystem.factorypattern;

public class CircleFactory extends AbstractShapeFactory{
    @Override
    public Shape createShape(){
        return new Circle();
    }
}
