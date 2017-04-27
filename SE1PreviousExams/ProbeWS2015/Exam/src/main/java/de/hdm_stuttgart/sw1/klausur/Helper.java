package de.hdm_stuttgart.sw1.klausur;

import java.util.ArrayList;
import java.util.List;

public class Helper {

	/**
	 * Durchsuche ein Array nach der Häufigkeit des Auftretens eines gegebenen Werts.
	 * <p
	 * Beispiel: Der Wert 3 taucht im Array {1, -5, 3, 0, 3} zweifach auf.
	 * <p>
	 * Sonderfall: Das Array ist null oder leer, dann ist das Ergebnis 0
	 *
	 * @param candidate Wert, dessen Häufigkeit im Array zu bestimmen ist
	 * @param werte     Werte, welche durchsucht werden
	 * @return Die Häufigkeit des aufgetretenen Werts.
	 */
	static public int getHaeufigkeit(final int candidate, final int[] werte) {
		if (werte == null || werte.length == 0) return 0;
		int count = 0;
		for (int i : werte) {
			if (i == candidate) count++;
		}
		return count;
	}

	/**
	 * Durchsuche ein Array nach aufeinanderfolgendem Auftreten identischer Werte und gebe ggf.
	 * den Index des ersten Werts der ersten Gruppe zurück.
	 * <p>
	 * Beispiel: Das Array {-4, 2, 3, 3, 3, -1, 7, 4, 4, 5} enthält zwei Gruppen benachbarter identischer Werte,
	 * nämlich {3, 3, 3} und {4, 4}. Da {3, 3, 3} die erste Gruppe ist, lautet der gesuchte Index 2.
	 * <p>
	 * Falls keine Gruppe existiert, soll ein Wert kleiner 0 zurückgegeben werden.
	 *
	 * @param werte Die zu durchsuchenden Werte
	 * @return Index des Beginns der ersten gefundenen Gruppe, oder < 0, falls keine Gruppe vorhanden.
	 */
	static public int getErstenGruppenIndex(final int[] werte) {
		if (werte == null || werte.length == 0) return -1;
		for (int i = 0; i < werte.length - 1; i++) {
			if (werte[i] == werte[i + 1]) return i;
		}
		return -1;
	}

	/**
	 * Wie oft tritt ein gegebenes Zeichen in einer Zeichenkette unter Ignorieren von Groß- und Kleinschreibung auf?
	 * <p>
	 * Beispiel: 'k' ist in "Klausur Softwareentwicklung" zweifach enthalten.
	 *
	 * @param c Ein beliebiges Zeichen
	 * @param s Eine beliebige Zeichenkette.
	 * @return Die Anzahl des Auftretens von c in der Zeichenkette s ohne Beachtung von Groß- und Kleinschreibung.
	 */
	static public int getZeichenHaeufigkeit(final char c, final String s) {
		if (s == null || s.length() == 0) return 0;
		int count = 0;
		String match = (c + "").toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			String w = s.substring(i, i + 1).toUpperCase();
			if (w.contentEquals(match)) count++;
		}
		return count;
	}


	/**
	 * Bildung der Schnittmenge zweier Wortmengen bei Beachtung von Groß/ und Kleinschreibung.
	 * <p>
	 * Beispiel:
	 * first = {"Haus", "laufen"}, second = {"Urlaub", "Klausur", "Haus", "Esel"}
	 * <p>
	 * Die Schnittmenge von first und second lautet {"Haus"}
	 *
	 * @param first  Die erste Wortmenge
	 * @param second Die zweite Wortmenge
	 * @return Die Wortmenge des Durchschnitts beider Wortmengen.
	 */
	static public String[] schnittmenge(final String[] first, final String[] second) {
		if (first == null || second == null) return null;
		if (first.length == 0) return second;
		if (second.length == 0) return first;
		List<String> match = new ArrayList<>();
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < second.length; j++) {
				if (first[i].contentEquals(second[j])) {
					match.add(first[i]);
				}
			}
		}
		return match.toArray(new String[0]);
	}
}
