package de.max;

/**
 * Created by max on 02.03.17.
 */
public class ExtendedEucild {
	private static double[][] calc = new double[30][6];

	public static void main(String[] args) {
		System.out.println(euklid(96,13));
	}

	public static int[] euklid(int a, int b){
		calc[0][0] = a;
		calc[0][1] = b;

		return new int[2];
	}

	private static void ggT(int row){
		if()
		calc[row][3] = calc[row][0] / calc[row][1];
	}

	private
}
