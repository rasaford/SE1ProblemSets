package de.max.chapter04.svg;

public class Circle {

	private double radius;
	private final double pi = Math.PI;
	private double xCoord;
	private double yCoord;
	
	public double getArea()
	{
		return pi * radius * radius;
	}
	public double getPerimeter()
	{
		return 2 * pi * radius;
	}
	public double getRadius()
	{
		return radius;
	}
	public void setRadius(double r)
	{
		this.radius = r;
	}
	
	public void setX(double x)
	{
		this.xCoord = x;
	}
	public void setY(double y)
	{
		this.yCoord = y;
	}
	
	public void writeSvg()
	{
		System.out.format("<circle r='%f' cx='%f' cy='%f'/>", radius, radius + xCoord, radius + yCoord);
		System.out.println("style= 'fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)'/>");
	}
	public Circle(double r)
	{
		this.radius = r;
	}
	
}
