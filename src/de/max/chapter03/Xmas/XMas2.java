package de.max.chapter03.Xmas;

public class XMas2 {
	private static void printIndent(int indentation, String s) {
		if (0 < indentation) {
			final String format = "%" + indentation + "s%s";
			System.out.format(format, "", s);
		} else {
			System.out.print(s);
		}
	}

	public static void main(String[] args) {
		final int numberOfRowGroups = 5; // You may easily change this value.

		printIndent(numberOfRowGroups + 1, "\\ /" + "\n"); // The tree's top.
		printIndent(numberOfRowGroups - 1, "-->*<--" + "\n");
		printIndent(numberOfRowGroups + 1, "/_\\" + "\n");

		// Part two: The tree's body
		//
		for (int rowGroup = 0; rowGroup < numberOfRowGroups; rowGroup++) { // tree's body.
			printIndent(numberOfRowGroups - rowGroup, "/");// Starting first
			// line of row
			for (int x = 0; x < rowGroup + 2; x++) { // group with (numberOfRows -
				System.out.print("_\\"); // row) tree body content.
			}
			System.out.println(); // Finishing current line.
			// Second body line of current group
			//
			printIndent(numberOfRowGroups - rowGroup - 1, ""); // Starting
			// second line
			for (int x = 0; x < rowGroup + 3; x++) { // of row group with
				System.out.print("/_"); // (numberOfRows - row - 1)
			} // tree body content.
			System.out.println("\\"); // Finishing current line.
		}

		// Part three: The tree's bottom trunk
		//
		printIndent(numberOfRowGroups, "[___]"); // Indenting the bottom trunk
		// ...
	}
}
