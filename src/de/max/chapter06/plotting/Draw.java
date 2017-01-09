package de.max.chapter06.plotting;

import java.time.Duration;

public class Draw {

	private int resX;
	private int resY;
	private double xP;
	private double xM;
	private double yP;
	private double yM;
	private double error;
	private double yMid;

	public Draw(int resX, int resY, double xP, double xM, double yP, double yM)
	{
		this.resX = resX;
		this.resY = resY;
		this.xP = xP;
		this.xM = xM;
		this.yP = yP;
		this.yM = yM;
	}

	public Draw()
	{
		this.resX = 20;
		this.resY = 20;
		this.xP = 1;
		this.xM = -1;
		this.yP = 1;
		this.yM = -1;
	}

	public void draw(double[] function)
	{
		int[][] graph = createArray(function);
		plot(graph);
	}

	private int[][] createArray(double[] function)
	{
		int[][] graph = new int[resY][resX];

		// numerical cell size
		error = (Math.abs(yP) + Math.abs(yM)) / resY;
		// mid point
		yMid = (Math.abs(yP) + Math.abs(yM)) / 2;
		double cellYValue = 0;

		for (int y = graph.length - 1; y >= 0; y--)
		{
			for (int x = 0; x < graph[0].length; x++)
			{
				cellYValue = y * error - yMid + error;
				if (function[x] <= cellYValue && function[x] >= cellYValue - error)
				{
					graph[y][x] = 1;
				}
			}
		}
		return graph;
	}

	private void plot(int[][] graph)
	{
		double cellY = 0;

		for (int y = 0; y < graph.length; y++)
		{
			for (int x = 0; x < graph[0].length; x++)
			{
				cellY = y * error - yMid + error;
				if (graph[y][x] == 1)
				{
					System.out.print("*");
				} 
				else if (cellY <= 0 && cellY >= 0 - error)
				{
					System.out.print("-");
				}else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
