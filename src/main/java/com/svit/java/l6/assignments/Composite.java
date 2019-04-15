package com.svit.java.l6.assignments;

import java.util.*;

interface Shape {
	void draw(String color);
}

class Triangle implements Shape {
	public void draw(String color) {
		System.out.println("Triangle with " + color);
	}
}

class Circle implements Shape {
	public void draw(String color) {
		System.out.println("Circle with " + color);
	}
}

public class Composite {
    private List<Shape> shapes = new ArrayList<>();
    
    public void draw(String color) {
    	for (Shape shape : shapes) {
    		shape.draw(color);
    	}   	
    }
    
    public void add(Shape shape) {
    	this.shapes.add(shape);
    }
    
    public static void main(String[] args) {
    	Composite composite = new Composite();
    	Shape triangle = new Triangle();
    	Shape circle = new Circle();
    	composite.add(triangle);
    	composite.add(circle);
    	composite.draw("Red");
    }
}
