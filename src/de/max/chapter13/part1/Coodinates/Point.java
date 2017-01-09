package de.max.chapter13.part1.Coodinates;

public class Point<T extends Number> {

	private T x, y;

	public Point(T x, T y)
	{
		this.x = x;
		this.y = y;
	}

	public T getX()
	{
		return this.x;
	}

	public T getY()
	{
		return this.y;
	}

	@Override
	public String toString()
	{
		return "(" + x + "|" + y + ")";
	}

	public boolean equals(Point<T> c)
	{
		return this.hashCode() == c.hashCode(); 
	}

	@Override
	public int hashCode()
	{
		Double result = this.x.doubleValue() * 31 + this.y.doubleValue();
		return Double.valueOf(result).hashCode();
	}
}
