package de.max.chapter04.svg;

import java.time.Period;

public class CircleDriver {
	public static void main(String[] args)
	{
		Circle c = new Circle(2.3);
		
		System.out.println("Rad: " + c.getRadius());
		System.out.println("Perimeter: " + c.getPerimeter());
		System.out.println("Area: " + c.getArea());
		
		c.setRadius(4.7);
		
		System.out.println("Rad: " + c.getRadius());
		System.out.println("Perimeter: " + c.getPerimeter());
		System.out.println("Area: " + c.getArea());
	}
}
