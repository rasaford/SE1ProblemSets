package de.max.chapter10.PlotterV2.functions;

/**
 * Created by max on 19.12.16.
 */
public class SinInverseX implements Function {
    @Override
    public double evaluateAt(double x) {
        return Math.sin(1/x);
    }
}
