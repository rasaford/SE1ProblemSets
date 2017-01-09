package de.max.chapter05;

public class AnalyzingStrings {

	public static void main(String[] args) {
		String input = "73167176531330624919225119674426574742355349194934"
				+ "96983520312774506326239578318016984801869478851843"
				+ "85861560789112949495459501737958331952853208805511"
				+ "12540698747158523863050715693290963295227443043557"
				+ "66896648950445244523161731856403098711121722383113"
				+ "62229893423380308135336276614282806444486645238749"
				+ "30358907296290491560440772390713810515859307960866"
				+ "70172427121883998797908792274921901699720888093776"
				+ "65727333001053367881220235421809751254540594752243"
				+ "52584907711670556013604839586446706324415722155397"
				+ "53697817977846174064955149290862569321978468622482"
				+ "83972241375657056057490261407972968652414535100474"
				+ "82166370484403199890008895243450658541227588666881"
				+ "16427171479924442928230863465674813919123162824586"
				+ "17866458359124566529476545682848912883142607690042"
				+ "24219022671055626321111109370544217506941658960408"
				+ "07198403850962455444362981230987879927244284909188"
				+ "84580156166097919133875499200524063689912560717606"
				+ "05886116467109405077541002256983155200055935729725"
				+ "71636269561882670428252483600823257530420752963450";

		int[] in = toIntArray(input);
		System.out.println("The max product is: " + maxProduct(in, 13));
	}

	// copies the elements of a string to an int[]
	private static int[] toIntArray(String str) {
		int len = str.length();
		int[] out = new int[len];

		for (int i = 0; i < out.length; i++) {
			// shift by 48 to turn the char numbers into int values
			out[i] = str.charAt(i) - '0';
		}
		return out;
	}

	// loops over the int[] and returns the max of the values in
	// step range multiplied together
	private static long maxProduct(int[] nums, int step) {
		long max = 0;
		String str = "";
		String digits = "";

		for (int i = 0; i < nums.length; i++) {
			// mult every step digits
			long current = 1;

			if (i < nums.length - step) { // make sure we are not out of bounds
											// of the array
				digits = "";
				for (int j = 0; j < step; j++) {
					current *= nums[i + j];
					digits = digits + nums[i + j];
				}
			}

			if (current > max) { // check for max
				max = current;
				str = digits;
			}
		}
		System.out.println("The digits are: " + str);
		return max;
	}
}
