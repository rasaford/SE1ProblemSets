package de.max.chapter03.Xmas;

public class XMas1 {
	public static void main(String[] args) {
		int rows = 10;
		String spaces = "";

		//generate spaces 
		for (int i = 0; i < rows; i++) {
			spaces += " ";
		}
		System.out.println(spaces + "X");

		//Main loop
		for (int i = 0; i < rows; i++) {
			//backward spaces
			for (int k = rows - i; k > 0; k--) {
				System.out.print(' ');
			}
			//forward stars
			for (int j = 0; j <= i * 2; j++) {
				System.out.print('*');
			}
			//line break
			System.out.println('\r');
		}
		System.out.println(spaces.substring(0, spaces.length() - 1) + "###");
		System.out.println(spaces.substring(0, spaces.length() - 1) + "###");

	}
}
