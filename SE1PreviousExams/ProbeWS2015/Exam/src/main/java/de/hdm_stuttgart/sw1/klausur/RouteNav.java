package de.hdm_stuttgart.sw1.klausur;

/**
 * Created by data on 14.01.17.
 */
public class RouteNav {
	public static void main(String[] args) {
		Segment[] route = new Segment[]{new Segment(1, 2), new Segment(3, 4)};

		for (int i = 0; i < route.length; i++) {
			Segment c = route[i];
			double[] data = c.getData();
			System.out.println("a=" + data[0] + ", b=" + data[1]);
		}
	}
}
