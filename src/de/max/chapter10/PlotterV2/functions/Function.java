package de.max.chapter10.PlotterV2.functions;

public interface Function {
	default double evaluateAt(double x) {
		return Math.sin(x);
	}
}
