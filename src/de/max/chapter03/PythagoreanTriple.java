package de.max.chapter03;

public class PythagoreanTriple {
	public static void main(String[] args) {
		goikTriple();
//		badTriple();
	}


	private static void goikTriple() {
		int count = 0;
		for (int a = 1; a <= 1000 / 3; a++) {
			// condition 2
			int ab = 1000 - a;
			int bMaximum;
			if (ab % 2 == 0) {
				bMaximum = ab / 2 - 1;
			} else {
				bMaximum = ab / 2;
			}

			int aSquare = a * a;
			for (int i = a; i <= bMaximum; i++) {
//				int c = 1000 - i - a;
				int c = ab - i;
				count++;
				// condition 3
				if (aSquare + i * i == c * c) {
					System.out.println("(" + a + ", " + i + ", " + c + ")");
				}
			}
		}
		System.out.println("After " + count + " iterations");
	}

	private static void goodTriple() {
		long start = System.currentTimeMillis();
		int maxVal = 1000;
		long count = 0;
		for (int i = 1; i < maxVal; i++) {
			for (int j = maxVal - i; j > i; j--) {
				int k = maxVal - j - i;
				count++;
				if ((i * i + j * j) == k * k) {
					System.out.format("Found a: %d, b: %d, c: %d\n", i, j, k);
					System.out.println("After " + count + " iterations");
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.format("Running Time: %d ms \n", (end - start));

	}

	private static void badTriple() {
		long start = System.currentTimeMillis();
		int count = 0;
		for (int a = 1; a < 998; a++) {
			for (int b = 1; b < 998; b++) {
				for (int c = 1; c < 998; c++) {
					count++;
					if (a * a + b * b == c * c && a + b + c == 1000) {
						System.out.println("Found (" + a + ", " + b + ", " + c + ")");
						System.out.println("After " + count + " iterations");
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.format("Running Time: %d ms \n", (end - start));
	}
}
