package com.example.LoggingSystem.factorypattern;

public class Application {
    public static void main(String[] args){
        AbstractShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();


        // create a Square using SquareFactory
        AbstractShapeFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        square.draw();
    }
}
