package com.example.LoggingSystem.factorypattern;

public class SquareFactory extends AbstractShapeFactory{
    @Override
    public Shape createShape(){
        return new Square();
    }
}
