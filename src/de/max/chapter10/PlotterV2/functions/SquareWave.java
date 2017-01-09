package de.max.chapter10.PlotterV2.functions;

/**
 * Created by max on 19.12.16.
 */
public class SquareWave implements Function {
    @Override
    public double evaluateAt(double x) {
        return (Math.sin(10*x) > 0) ? 0.5 : -0.5;
    }
}
