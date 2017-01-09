package de.max.chapter10.PlotterV2;

import de.max.chapter10.PlotterV2.functions.Function;
import de.max.chapter10.PlotterV2.functions.Sin;

public class Plotter {

    private int[] res;
    private Function function;
    private double[] plot;
    private double xSize;
    private double xMid;
    private double ySize;
    private double yMid;

    public Plotter(Function function, Window window) {
        this.function = function;
        this.res = window.getRes();
        this.xSize = window.getCellXSize();
        this.xMid = window.getXMidPoint();
        this.ySize = window.getCellYSize();
        this.yMid = window.getYMidPoint();
    }

    public Plotter() {
        Window window = new Window(20, 30, 1, -1, 1, -1);
        new Plotter(new Sin(), window);
    }

    public void draw() {
        this.plot = evaluateFunction(function);
        int[][] graph = pixelArray(plot);
        plotToConsole(graph);
    }

    // for each pixel in resX evaluate the Function and write the result into an Array
    private double[] evaluateFunction(Function function) {
        double[] plot = new double[res[0]];
        for (int i = 0; i < res[0]; i++) {
            double x = i * xSize - xMid + xSize;
            plot[i] = function.evaluateAt(x);
        }
        return plot;
    }

    /**
     * .
     *
     * @param function
     * @return
     */
    private int[][] pixelArray(double[] function) {
        int[][] graph = new int[res[1]][res[0]]; // res Y // resX
        double cellYValue = 0;

        for (int y = 0; y < graph.length; y++) {
            for (int x = 0; x < graph[0].length; x++) {
                cellYValue = y * ySize - yMid + ySize;
                if (function[x] <= cellYValue && function[x] >= cellYValue - ySize) {
                    graph[y][x] = 1;
                }
            }
        }
        return graph;
    }

    private void plotToConsole(int[][] graph) {
        double cellY = 0;
        double cellX = 0;

        System.out.format("Plotting %s(x): \n\n", this.function.getClass().getSimpleName());
        // has to be read in reverse y because otherwise the graph is inverted
        // in Y
        for (int y = graph.length - 1; y >= 0; y--) {
            plotAxisScale(y);
            for (int x = 0; x < graph[0].length; x++) {
                // calc the current real x, y cell value
                cellY = y * ySize - yMid;
                cellX = x * xSize - xMid;
                if (graph[y][x] == 1) {
                    System.out.print("*");
                } // print horizontal line
                else if (cellY <= 0 && cellY >= 0 - ySize) {
                    System.out.print("—");
                } // print vertical line
                else if (cellX <= 0 && cellX >= 0 - ySize) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void plotAxisScale(int y) {
        double cellY = y * ySize - yMid;
        String spaces = "    | ";

        if (cellY <= 0 && cellY >= 0 - ySize) {
            System.out.format("%4.1f| ", cellY);
        } else if (y == 0 || y == res[1] - 1) {
            System.out.format("%4.1f| ", cellY);
        } else if (y % (res[0] + res[1]) % 5 == 0) {
            System.out.format("%4.1f| ", cellY);
        } else {
            System.out.print(spaces);
        }
    }
}
