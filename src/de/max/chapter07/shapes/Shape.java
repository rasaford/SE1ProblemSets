package de.max.chapter07.shapes;

public class Shape {
	
	protected double x;
	protected double y;
	
	public Shape(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getPerimeter()
	{
		return 0;
	}
	
	public double getArea()
	{
		return 0;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public void setPos(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Shape move(double x, double y)
	{
		return new Shape(x,y);
	}
	
	public Shape scale(double factor)
	{
		return new Shape(x,y);
	}
	
	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + " (" + x + ","+ y + ")";
	}
}
