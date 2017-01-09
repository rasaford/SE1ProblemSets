package de.max.chapter04.svg;

public class Rectangle {
	
	private double width;
	private double height;
	private double xCoord;
	private double yCoord;
	
	public void setWidth(double width)
	{
		this.width = width;
	}
	public double getWidth()
	{
		return width;
	}
	public void setHeight(double height)
	{
		this.height = height;
	}
	public double getHeight()
	{
		return height;
	}
	
	public double getPerimeter()
	{
		return (width + height) * 2;
	}
	public double getArea()
	{
		return width * height;
	}
	
	public void setX(double x)
	{
		this.xCoord = x;
	}
	public void setY(double y)
	{
		this.yCoord = y;
	}
	
	public Rectangle(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
}
