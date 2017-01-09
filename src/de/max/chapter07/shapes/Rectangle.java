package de.max.chapter07.shapes;

public class Rectangle extends Shape {

	private double width;
	private double height;

	public Rectangle(double x, double y, double w, double h)
	{
		super(x, y);
		this.width = w;
		this.height = h;
	}

	public double getWidth()
	{
		return width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	@Override
	public double getPerimeter()
	{
		return width * 2 + height * 2;
	}

	@Override
	public double getArea()
	{
		return width * height;
	}

	@Override
	public Rectangle scale(double factor)
	{
		return new Rectangle(x, y, width * factor, height * factor);
	}
	
	public String toString()
	{
		return super.toString() + ", width = " + width + ", height = " + height; 
	}
}
