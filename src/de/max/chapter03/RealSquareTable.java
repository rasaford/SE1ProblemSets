package de.max.chapter03;

public class RealSquareTable {
	public static void main(String[] args) {
		int cols = 5;
		int blocks = 2;
		int entries = 10;
		String spaces = "     ";
		String dashes = "-----";

		// print the header
		for (int i = 0; i < cols; i++) {
			System.out.print("  n |  n*n" + spaces);
		}
		System.out.println();

		// for each row (blocks * entries)
		for (int cRow = 0; cRow < blocks * entries; cRow++) {
			// if one block is done print the dashed line
			if (cRow % entries == 0) {
				// repeat for each column
				for (int i = 0; i < cols; i++) {
					System.out.print("----" + "+" + "-----" + dashes);
				}
				System.out.println();
			}

			// for each column in a row
			for (int cCol = 0; cCol < cols; cCol++) {
				// current column * number of entries * number of rows
				// + current row
				int n = cRow + cCol * entries * blocks;
				System.out.format("%3d |%5d" + spaces, n, n * n);
			}
			System.out.println();
		}
	}
}