package de.max.chapter04.svg;

public class Svg {
	public static void main(String[] args)
	{
		System.out.println("<!DOCTYPE html><html><body>");
		System.out.println("    <svg width='300' height='200' >");
		
		// Rect
		Rectangle r = new Rectangle(5, 4);
		r.setX(2);
		r.setY(1);
		//r.
		// Cricle
		Circle c = new Circle(1);
		c.setX(3);
		c.setY(1);
		c.writeSvg();
		System.out.println(    "</svg>");
		System.out.println("</body></html>");
	}
}
