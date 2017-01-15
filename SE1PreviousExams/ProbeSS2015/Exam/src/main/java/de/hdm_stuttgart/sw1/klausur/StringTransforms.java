package de.hdm_stuttgart.sw1.klausur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Ersetzungen in Zeichenketten.
 */
public class StringTransforms {
	private static Logger log = LogManager.getLogger(StringTransforms.class);

	/**
	 * Eine urbane Legende attestiert Chinesen das Problem der Aussprache des
	 * Buchstabens "r". Sie würden stattdessen ein "l" verwenden.
	 * <p>
	 * Die Methode ersetzt alle Buchstaben 'r' durch 'l' bzw. 'R' durch 'L'.
	 * <p>
	 * Beispiel:
	 * <p>
	 * Aus "Der arme Richard" wird "Del alme Lichald"
	 *
	 * @param input Eine beliebige, von null verschiedene Zeichenkette
	 * @return Die Ersetzung der Zeichenkette gemäß {'r' zu 'l', 'R' zu 'L'}
	 */
	public static String chinesischerAkzent(final String input) {
		if (input == null || input.length() == 0) return input;
		return input.replace("r", "l").replace("R", "L");
	}

	/**
	 * Sprachwissenschaftler sind der Ansicht, dass auch nach dem Entfernen von
	 * Vokalen der Text lesbar bleibt. Beispiel: "Die Anden" wird zu "D ndn"
	 *
	 * @param input Eine beliebige Zeichenkette oder null
	 * @return null, falls Eingabe null, sonst der Eingabestring ohne Vokale {aeiouAEIOU}
	 */
	public static String entferneVokale(final String input) {
		if (input == null || input.length() == 0) return input;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			String w = input.substring(i, i + 1);
			if (!"aeoiuAEIOU".contains(w)) sb.append(w);
		}
		return sb.toString();
	}

	/**
	 * Umwandlung eines Wortes (ohne Leerzeichen) in Morsezeichen gemäß dem Morse Alphabet als
	 * Folge langer (-) und kurzer (.) durch Pausen (Leerzeichen) getrennter Töne:
	 * <p>
	 * A .-    D -..  G --.  J .--- M --
	 * B -...  E .    H .... K -.-  N -.
	 * C -.-.  F ..-. I ..   L .-..
	 * Buchstaben O bis Z sowie Ziffern 0 bis 9 aus Platzgründen weggelassen. Diese brauchen
	 * in der Klausur aus Zeitgründen nicht implementiert zu werden.
	 * <p>
	 * Regeln:
	 * -Kleinbuchstaben werden zunächst in Großbuchstaben umgewandelt
	 * -Pro Buchstabe / Ziffer wird nach der Morse Zeichenfolge eine Pause (Leerzeichen) eingefügt.
	 * <p>
	 * Beispiel (Leerzeichen beachten, auch am Ende des Morsecodes):
	 * Aus "Abend" wird ".- -... . -. -.. "
	 *
	 * @param input Das Klartextwort, welches durch Morsezeichen kodiert werden soll.
	 * @return Die Übersetzung in das Morsealphabet.
	 */
	public static String morsen(final String input) {
		if (input == null || input.length() == 0) return input;
		StringBuilder sb = new StringBuilder();
		Map<String, String> map = new HashMap<>();
		map.put("A", ".-");
		map.put("B", "-...");
		map.put("C", "-.-.");
		map.put("D", "-..");
		map.put("E", ".");
		map.put("F", "..-.");
		map.put("G", "--.");
		map.put("H", "....");
		map.put("I", "..");
		map.put("J", ".---");
		map.put("K", "-.-");
		map.put("L", ".-..");
		map.put("M", "--");
		map.put("N", "-.");
		for (int i = 0; i < input.length(); i++) {
			String w = input.substring(i, i + 1).toUpperCase();
			if (!w.matches("[a-zA-z0-9]")) {
				throw new MorseException(input, w);
			}
			String result = map.get(w);
			sb.append(result + " ");
		}
		return sb.toString();
	}
}
