package de.max.chapter04.svg;

public class RectDriver {
	public static void main(String[] args)
	{
		Rectangle r = new Rectangle(8, 5);
		System.out.println("Perimeter: " + r.getPerimeter());
		System.out.println("Area: " + r.getArea());
		
		r.setWidth(4);
		r.setHeight(7);
		
		System.out.println("Perimeter: " + r.getPerimeter());
		System.out.println("Area: " + r.getArea());
	}
}
