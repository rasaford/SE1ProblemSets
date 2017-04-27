package de.max;

/**
 * Created by max on 06.04.17.
 */
public class test3 {

	public static void main(String[] args) {
		int numbers = 20;
		int check = numbers;
		boolean continueLoop = true;
		while (continueLoop) {
			check++;
			continueLoop = false;
			for (int i = 2; i <= numbers; i++) {
				if (check % i != 0) {
					continueLoop = true;
					break;
				}
			}
		}
		System.out.println(check);
	}

}
