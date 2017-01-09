package de.max.chapter10.PlotterV2;

import de.max.chapter04.MathLibrary.Math;

public class Window {

    private int[] res;
    private double[] window;

    public Window(int resX, int resY, double xP, double xM, double yP, double yM) {
        this.res = new int[]{resX, resY};
        this.window = new double[]{xP, xM, yP, yM};
    }

    public int[] getRes() {
        return this.res;
    }

    public double[] getWindow() {
        return this.window;
    }

    public double getCellXSize() {
        return (Math.abs(this.window[0]) + Math.abs(this.window[1])) / res[0];
    }

    public double getCellYSize() {
        return (Math.abs(this.window[2]) + Math.abs(this.window[3])) / res[1];
    }

    public double getXMidPoint() {
        return (Math.abs(this.window[0]) + Math.abs(this.window[1])) / 2;
    }

    public double getYMidPoint() {
        return (Math.abs(this.window[2]) + Math.abs(this.window[3])) / 2;
    }
}
