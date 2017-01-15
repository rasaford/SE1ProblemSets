package de.hdm_stuttgart.sw1.klausur;

/**
 * Created by data on 14.01.17.
 */
public class Segment {

	private double[] data;

	Segment(double a, double b) {
		this.data = new double[]{a, b};
	}

	public double[] getData() {
		return this.data;
	}

}
