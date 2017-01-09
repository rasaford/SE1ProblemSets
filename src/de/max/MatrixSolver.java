package de.max;

public class MatrixSolver {

	public static void main(String[] args) {
		double[][] in1 = {	{1, 2, 3, 1}, 
							{4, 5, 6, 1}, 
							{1, 0, 1, 1}};
		double[][] in2 = {	{2, 1, 1, 1}, 
							{4, 1, 3, 1}, 
							{-2, 2, 1, 7}};
		double[][] in3 = {	{2, -1, 1, -8}, 
							{3, 1, -2, 1}, 
							{-5, 2, -1, 15}};
		double[][] in4 = {	{1, 1, 1, 1, -2},
							{-1, 1, -1, 1, -10},
							{3, 2, 1, 2, -2},
							{0, -2, 0, 1, 0}};
		double[][] in5 = {	{2, 1, -2, 3, 2},
							{1, 2, 1, -4, 8}, 
							{-1, 3, -4, 1, 0},
							{3, 2, 2, 2, 6}	};
		double[][] in6 = {	{1, 1, -2, 1, 3, -1, 4},
							{2, -1, 1, 2, 1, -3, 20},
							{1, 3, -3, -1, 2, 1, -15},
							{5, 2, -1, -1, 2, 1, -3},
							{-3, -1, 2, 3, 1, 3, 16},
							{4, 3, 1, -6, -3, -2, -27}};
		double[][] in7 = {	{0.0625, 0.125, 0.25, 0.5, 1, 0},
							{1, 1, 1, 1, 1, 0},
							{5.0625, 3, 2.25, 1.5, 1, 0},
							{13.5, 6.75, 3, 1, 0, 0}	};
		solve(in7, true);
	}

	public static void solve(double[][] in, boolean step) {
		
		System.out.println("Input matrix: ");
		print(in);
		
		double[] result = gauss(in, step);
		System.out.println("\nresults:");

		for (int i = 0; i < result.length; i++) {
			System.out.format("x%d = %4.1f \n",i + 1, result[i]);
		}
		System.out.println();
	}
	
	
	private static double[] gauss(double[][] a, boolean step) {
		int n = a.length;

		for (int i = 0; i < n; i++) {
			// search for the max in the current column
			// assume the current row has the max value in this column
			// then check the assumption
			double maxEl = Math.abs(a[i][i]);
			int maxRow = i;
			for (int k = i + 1; k < n; k++) {
				if (Math.abs(a[k][i]) > maxEl) {
					maxEl = Math.abs(a[k][i]);
					maxRow = k;
				}
			}
			// the row with the highest absolute value for xn has to be on top
			// swap max row with current row (column by column)
			for (int k = i; k <= n; k++) {
				double temp = a[maxRow][k];
				a[maxRow][k] = a[i][k];
				a[i][k] = temp;
			}
			// show the step if a swap will be made and the user wants to see it
			if (step && maxRow != i) {
				System.out.format("swaping rows: (%d,%d) \n", i + 1, maxRow + 1);
				print(a);
			}

			// make all rows below this one 0 in the current column
			// take the next row and add to it the previous one multiplied by
			// their negative difference
			// this gets the current xn to be 0 in that row
			// repeat for all rows below this one
			for (int k = i + 1; k < n; k++) {
				double c = -a[k][i] / a[i][i];
				if (step) {
					System.out.format("adding row %d * %6.3f to row %d \n", i + 1, c, k + 1);
				}
				for (int j = i; j <= n; j++) {
					if (i == j) {
						a[k][j] = 0;
					} else {
						a[k][j] += c * a[i][j];
					}
				}
				if (step) {
					print(a);
				}
			}
		}

		// solve after getting the triangular matrix
		double[] result = new double[a.length];
		for (int i = n - 1; i >= 0; i--) {
			result[i] = a[i][n] / a[i][i];
			if (step) {
				System.out.format("\nx%d is equal to %5.2f / %5.2f = %5.2f \n\n", i + 1, a[i][n], a[i][i], result[i]);
			}
			for (int k = i - 1; k >= 0; k--) {
				a[k][n] -= a[k][i] * result[i];
				if (step) {
					System.out.format("subtracting x%d from row %d \n", i + 1, k + 1);
					System.out.format("row %d can now be written as: \n ", k + 1);
					for (int l = 0; l < i; l++) {
						if (a[k][l] != 0) {
							System.out.format("%5.2fx%d ", a[k][l], l + 1);
							if (l != i - 1) {
								System.out.print("+");
							}
						}
					}
					System.out.format("= %5.2f\n\n", a[k][n]);
				}
			}
		}
		return result;
	}

	private static void print(double[][] in) {

		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[0].length; j++) {
				if (j == in[0].length - 1) {
					System.out.format("|%5.2f ", in[i][j]);
				} else {
					System.out.format("%5.2f ", in[i][j]);
				}

			}
			System.out.println();
		}
		System.out.println();
	}
}

