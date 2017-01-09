package de.max.chapter10.PlotterV2;

import de.max.chapter10.PlotterV2.functions.XSquared;

public class ScreenDriver {
    public static void main(String[] args) {
        int resX = 200;
        int resY = 50;
        double windowXPlus = Math.PI;
        double windowXMinus = -Math.PI;
        double windowYPlus = 1;
        double windowYMinus = -1;

        Window window = new Window(resX, resY, windowXPlus, windowXMinus, windowYPlus, windowYMinus);
        Plotter plotter = new Plotter(new XSquared(), window);
        plotter.draw();
    }

}
