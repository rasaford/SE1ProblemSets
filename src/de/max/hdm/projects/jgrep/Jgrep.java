package de.max.hdm.projects.jgrep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jgrep {

	private String[] document;

	public Jgrep() {

	}

	// parses the given string for the args given to jgrep
	// invokes all other methods
	public void parse(String userInput) {
		String[] args = toStringArray(userInput, ' ');
		String key = "";
		ArrayList<String> filePaths = new ArrayList<String>();
		boolean caseSensitive = true;
		boolean fileName = false;

		// resolves the given args
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-i")) {
				caseSensitive = false;
			} else if (args[i].equals("-l")) {
				fileName = true;
			} else if (args[i].contains(".")) {
				filePaths.add(args[i]);
			} else {
				key = args[i];
			}
		}
		// in the case of multiple files to parse this repeats until all files
		// have been searched
		for (String path : filePaths) {
			this.document = readFile(path);
			findMatches(key, path, caseSensitive, fileName);
		}
	}

	// fins the matches of the given key inside the document
	// then echos the line containing the key
	// a line is determined by a "." char
	private void findMatches(String key, String path, boolean caseSensitive, boolean fileName) {
		for (String word : document) {
			if (contains(key, word, caseSensitive)) {
				if (fileName) {
					System.out.println(path);
					break;
				} else {
					System.out.println(word);
				}
			}
		}
	}

	// split the given string by the char split and return the resulting strings
	// as a String array
	private String[] toStringArray(String doc, char split) {
		// count words
		int wordCount = 0;
		for (int i = 0; i < doc.length(); i++) {
			if (doc.charAt(i) == split) {
				wordCount++;
			}
		}
		// split the String
		String[] words = new String[wordCount];
		int lastWord = 0;
		int index = 0;
		for (int i = 0; i < doc.length(); i++) {
			if (doc.charAt(i) == split) {
				words[index++] = doc.substring(lastWord, i + 1).trim();
				lastWord = i + 1;
			}
		}
		return words;
	}

	// returns a boolean value weather or not the word contains the key.
	// has an option to ignore the case of the key
	private boolean contains(String key, String word, boolean caseSensitive) {
		int keyLen = key.length();

		if (caseSensitive) {
			for (int i = 0; i <= word.length() - keyLen; i++) {
				if (word.substring(i, i + keyLen).equals(key)) {
					return true;
				}
			}
		} else {
			for (int i = 0; i <= word.length() - keyLen; i++) {
				if (word.substring(i, i + keyLen).equalsIgnoreCase(key)) {
					return true;
				}
			}
		}
		return false;
	}

	// outputs each line in the designated file as an Entry in a String[]
	private String[] readFile(String location) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(location));
			ArrayList<String> document = new ArrayList<String>();
			String currLine;

			// continue to append until the end of file has been reached
			while ((currLine = reader.readLine()) != null) {
				// avoiding empty strings
				if (!currLine.isEmpty())
					document.add(currLine);
			}
			reader.close();
			return document.toArray(new String[1]);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// sadly neccessary default return case
		return new String[0];
	}
}
