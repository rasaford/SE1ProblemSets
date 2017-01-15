package de.hdm_stuttgart.sw1.klausur;

/**
 * Created by data on 14.01.17.
 */
public class MorseException extends RuntimeException {
	private String message;

	public MorseException(String input, String error) {
		message = "Eingabezeichenkette '" + input + "' enthält nicht-Morsezeichen '" + error + "'.";
	}

	public String getMessage() {
		return message;
	}
}
