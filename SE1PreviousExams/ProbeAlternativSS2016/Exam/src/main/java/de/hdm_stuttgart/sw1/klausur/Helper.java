package de.hdm_stuttgart.sw1.klausur;


public class Helper {

	/**
	 * Gebe den größeren der beiden Werte zurück, mindestens aber 0.
	 *
	 * @param a Erster Wert
	 * @param b Zweiter Wert
	 * @return Den größeren der beiden Eingabewerte. Falls beide Werte kleiner als 0 sind, wird 0 zurückgegeben.
	 */
	static public int maxMindestensNull(final int a, final int b) {
		return Math.max(Math.max(a, b), 0);
	}

	/**
	 * Umkehrung der Reihenfolge aller durch einzelne Leerzeichen getrennten Worte eines Satzes. Beispiele:
	 * <p>
	 * <ol>
	 * <li><b>"Dies ist gut an der HdM"</b> wird zu <b>"HdM der gut ist Dies"</b></li>
	 * <li><b>"Ein Test"</b> wird zu <b>"Test Ein"</b></li>
	 * </ol>
	 *
	 * @param satz Ein Satz aus Worten, welche durch einzelne Leerzeichen (" " bzw. ' ') voneinander getrennt sind.
	 * @return Die Worte des Satzes in umgekehrter Reihenfolge.
	 * Ein null Wert oder eine leere Zeichenkette werden identisch zurückgegeben.
	 * <p>
	 * <p  style="color: red;font-weight: bold;">Tip: Nutzen Sie die Methode {@link String#split(String)} mit " " als Trennsymbol zur Zerlegung des Satzes in Worte.</p>
	 */
	static public String getUmgekehrteReihenfolge(final String satz) {
		if (satz == null || satz.length() == 0) return satz;
		String[] split = satz.split(" ");
		String[] out = new String[split.length];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) out[i] = split[split.length - i - 1];
		for (String i : out) sb.append(i + " ");
		return sb.toString().trim();
	}

	/**
	 * Erzwinge Großbuchstaben für den jeweils ersten Buchstaben aller Worte eines Satzes. Worte bestehen aus denjenigen char Zeichen,
	 * für welche die Methode {@link Character#isLetterOrDigit(char)} wahr ist. Insbesondere dürfen Worte auch Ziffern enthalten.
	 * Sonderzeichen sind hingegen ausgeschlossen und gelten als Worttrenner. Beispiele:
	 * <p>
	 * <ol>
	 * <li><b>"source Code kennt das Konzept des CamelCase"</b> wird zu <b>"Source Code Kennt Das Konzept Des CamelCase"</b></li>
	 * <li><b>"miles o'Brien"</b> wird zu <b>"Miles O'Brien"</b></li>
	 * <li><b>"Das Kunstwort just4all"</b> wird zu <b>"Das Kunstwort Just4all"</b></li>
	 * </ol>
	 *
	 * @param input Der Eingabesatz
	 * @return Der potentiell umgewandelte Satz. Für die Eingabe null oder "" ändert sich nichts.
	 * <p>
	 * <p  style="color: red;font-weight: bold;">Tip: Nutzen Sie die Methode {@link String#toCharArray()} zur Zerlegung des Satzes in einzelne Zeichen.
	 * Erzeugen Sie daraus das Ergebnis unter Verwendung von {@link Character#isLetterOrDigit(char)} und {@link Character#toUpperCase(char)}.</p>
	 */
	static public String capitalize(final String input) {
		if (input == null || input.length() == 0) return input;
		String[] split = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			String w = split[i].substring(0, 1).toUpperCase();
			sb.append(w + split[i].substring(1) + " ");
		}
		return sb.toString().trim();
	}

	/**
	 * Funktionalität ähnlich zu {@link Integer#parseInt(String)}. Allerdings wird im Fall einer nicht umwandelbaren Eingabe
	 * das Werfen einer {@link NumberFormatException} durch Rückgabe des Werts 0 ersetzt. Beispiele:
	 * <p>
	 * <dl>
	 * <dt>Normalfall: String repräsentiert eine Ganzzahl</dt>
	 * <dd>z.B. input == "42", Rückgabe 42 (int)</dd>
	 * <p>
	 * <dt>Ausnahmefall: String repräsentiert keine Ganzzahl</dt>
	 * <dd>z.B. input == "Geht nicht" oder input == null: Rückgabe 0</dd>
	 * </dl>
	 *
	 * @param input Eine beliebige Zeichenkette oder null
	 * @return 0, falls input == null ist oder input nicht in einen int Wert umgewandelt werden kann. Ansonsten den durch input
	 * festgelegten int Wert.
	 * <p>
	 * <p  style="color: red;font-weight: bold;">Tip: Nutzen Sie die Methode {@link Integer#parseInt(String)} und behandeln Sie allfällige Ausnahmen.</p>
	 */
	static public int parseIntOhneAusnahme(final String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * <p>Rotiere die Werte eines Feldes zyklisch nach "rechts". Der letzte Feldwert wird an den Anfang verschoben. Beispiel:</p>
	 * <p>
	 * <p><b>{1, 2, 3, 4, 5, 6}</b> wird zu <b>{6, 1, 2, 3, 4, 5}</b> </p>
	 *
	 * @param values Das zu verschiebende Feld aus Werten. Die Werte werden beim Aufruf zyklisch nach "rechts" verschoben. Falls
	 *               das Feld null oder leer ist, erfolgt keine Aktion.
	 */
	static public void zyklischRechtsRotieren(final int[] values) {
		if (values == null || values.length < 2) return;
		// in place incremental swap
		for (int i = values.length - 1; i > 0; i--) {
			int temp = values[i];
			values[i] = values[i - 1];
			values[i - 1] = temp;
		}
	}
}