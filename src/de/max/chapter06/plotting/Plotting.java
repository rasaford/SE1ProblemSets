package de.max.chapter06.plotting;

public class Plotting {
	public static void main(String[] args)
	{
		int resX = 75;
		int resY = 25;
		double windowXPlus = 1;
		double windowXMinus = 1;
		double windowYPlus = 1;
		double windowYMinus = 1;
		
		double[] function = new double[resX];

		for (int x = 0; x < function.length; x++)
		{
			function[x] = Math.sin(x / 7.0);
		}		
		
		Draw draw = new Draw(resX, resY, windowXPlus, windowXMinus, windowYPlus, windowYMinus);
		draw.draw(function);
	}


}
