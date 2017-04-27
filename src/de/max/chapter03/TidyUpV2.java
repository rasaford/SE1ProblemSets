package de.max.chapter03;

public class TidyUpV2 {
	public static void main(String[] args) {
		int length = 20;

		System.out.println("n | n * n");
		System.out.println("--+------");
		for (int i = 0; i < length; i++) {
			int squared = i * i;
			System.out.format("%2d|%6d\n", i, squared);
		}
	}
}
