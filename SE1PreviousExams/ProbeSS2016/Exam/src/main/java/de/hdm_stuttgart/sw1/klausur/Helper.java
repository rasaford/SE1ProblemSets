package de.hdm_stuttgart.sw1.klausur;


import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class Helper {

	/**
	 * <p>Liefert die Deutschen Klartextnamen der Zahlen von 0 bis Zwölf, also:</p>
	 * <p>
	 * <p>{0, 1, 2, ..., 12} wird zu {"eins", "zwei", ..., "zwölf"}</p>
	 * <p>
	 * <p>Für alle anderen Werte soll "Uuups, keine Regel für den Wert X" zurückgegeben werden.</p>
	 *
	 * @param a Umzuwandelnder Wert
	 * @return Klartextname.
	 */
	static public String klartextName(final int a) {
		Map<Integer, String> map = new HashMap<>();
		map.put(0, "null");
		map.put(1, "eins");
		map.put(2, "zwei");
		map.put(3, "drei");
		map.put(4, "vier");
		map.put(5, "fünf");
		map.put(6, "sechs");
		map.put(7, "sieben");
		map.put(8, "acht");
		map.put(9, "neun");
		map.put(10, "zehn");
		map.put(11, "elf");
		map.put(12, "zwölf");

		String result = map.get(a);
		if (result != null) return result;
		else return "Uuups, keine Regel für den Wert " + a;
	}

	/**
	 * Gibt den Betrag des Produkts der beiden Faktoren zurück.
	 *
	 * @param a Erster Wert
	 * @param b Zweiter Wert
	 * @return Betrag des Produkts.
	 */
	static public int getProduktBetrag(final int a, final int b) {
		return Math.abs(a * b);
	}

	/**
	 * Der Quadrant für einen gegebenen Winkel.
	 * <p>
	 * Der Vollkreis wird in 0 bis 360 Grad eingeteilt. Je nach Winkel liegt ein Vektor
	 * im Quadrant 1, 2 3 oder 4:
	 * <p>
	 * |
	 * Quadrant 2   |  Quadrant 1
	 * |
	 * |
	 * --------------+-------------
	 * |
	 * |
	 * Quadrant 3   | Quadrant 4
	 * |
	 * <p>
	 * Werte von einschließlich 0 bis ausschließlich 90 Grad liegen im ersten Quadranten usw.
	 * <p>
	 * <p>
	 * Gibt den Betrag des Produkts der beiden Faktoren zurück.
	 *
	 * @param winkel Winkel des zu betrachtenden Vektors aus dem Intervall [0, 360[.
	 * @return zugehöriger Quadrant.
	 */
	static public int getQuadrant(final double winkel) {
		return (int) (winkel / 90) + 1;
	}

	/**
	 * Umwandlung von Sekundenangaben in das Format hh:mm:ss Beispiel:
	 * <p>
	 * 7290 Sekunden entsprechen 2 Stunden, einer Minute und 30 Sekunden, also "2:1:30"
	 *
	 * @param sekunden Nicht-negative Sekundenangabe
	 * @return Angabe in Stunden:Minuten:Sekunden
	 */
	static public String getZeitangabe(final long sekunden) {
		long sec = sekunden % 60;
		long min = ((sekunden - sec) / 60) % 60;
		long hrs = sekunden / 3600;
		Formatter f = new Formatter();
		return f.format("%d:%d:%d", hrs, min, sec).toString();
	}

	/**
	 * <p>Kehre die Reihenfolge der Werte eines Feldes um. Beispiel:</p>
	 * <p>
	 * <p> {1, 2, 3, 4, 5} wird zu {5, 4, 3, 2, 1}
	 *
	 * @param werte Ein Feld aus Werten oder null (keine Aktion).
	 */
	// WHAT IS THIS SHIT ??!!!
	static public int[] spiegelung(int[] werte) {
		if (werte == null || werte.length == 0) return werte;
		for (int a : werte) System.out.println("a.in = " + a);
		int[] out = new int[werte.length];
		for (int i = 0; i < werte.length; i++) {
			out[i] = werte[werte.length - i - 1];
		}
		System.out.println("out.length = " + out.length);
		for (int a : out) System.out.println("a = " + a);
		return out;
	}

	/**
	 * <p>Prüfe die Gültigkeit einer ISBN Nummer.</p>
	 * <p>
	 * <p>Eine gegebene ISBN Nummer ist gültig, wenn:</p>
	 * <p>
	 * <ul>
	 * <li>Sie aus 10 Ziffern besteht und ansonsten nur "-" Zeichen enthält</li>
	 * <p>
	 * <li><p>Das Produkt 1 * d_1 + 2 * d_2 + ... + 10 * d_10 ein Vielfaches von 11 ist, wobei {d_10 d_9 ...,d_1} die Ziffern von rechts nach links darstellen</p>
	 * <p>Beispiel: Die ISBN Nummer 0-201-31452-5 ist gültig:</p>
	 * <p>Produkt von rechts nach links 1*5 + 2*2 + 3*5 + 4*4 + 5*1 + 6*3 + 7*1 + 8*0 + 9*2 + 10*0 = 88, also ein Vielfaches von 11.</p>
	 * <p>
	 * <p>18-433-6928-3 ist hingegen ungültig. Ebenso 2234-223-12, da nur 9 Ziffern vorhanden sind.</p>
	 * <p>
	 * </li>
	 * </ul>
	 *
	 * @param isbn Referenznummer eines Buchs
	 * @return true or false
	 * <p>
	 * <p style="color: red;font-weight: bold;">Tip: Beachten Sie {@link Character#getNumericValue(char)} und {@link String#toCharArray()}.</p>
	 */
	static public boolean istGueltig(final String isbn) {
		String digits;
		int sum = 0;
		if (isbn == null || (digits = isbn.replaceAll("-", "")).length() != 10) return false;
		for (int i = 0; i < digits.length(); i++) sum += (i + 1) * Integer.parseInt(digits.substring(i, i + 1));
		return (sum % 11) == 0;
	}
}