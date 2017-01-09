package de.max.chapter10.PlotterV2.functions;

public class Sin implements Function {
	
	@Override
	public double evaluateAt(double x) {
		return Math.sin(x);
	}
}
