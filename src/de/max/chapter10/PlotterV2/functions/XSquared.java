package de.max.chapter10.PlotterV2.functions;

/**
 * Created by max on 19.12.16.
 */
public class XSquared implements Function {
    @Override
    public double evaluateAt(double x) {
        return 0.5 * x * x;
    }
}
