package de.max.chapter07.shapes;

public class Circle extends Shape {

	private double radius;

	public Circle(double x, double y, double radius)
	{
		super(x, y);
		this.radius = radius;
	}

	public double getRadius()
	{
		return this.radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	@Override
	public double getPerimeter()
	{
		return 2 * Math.PI * radius;
	}

	@Override
	public double getArea()
	{
		return Math.PI * radius * radius;
	}

	@Override
	public Circle scale(double factor)
	{
		return new Circle(x, y, radius * factor);
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", radius = " + radius;
	}
}
