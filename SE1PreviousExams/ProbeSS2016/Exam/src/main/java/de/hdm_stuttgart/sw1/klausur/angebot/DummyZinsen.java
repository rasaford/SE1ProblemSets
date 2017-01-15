package de.hdm_stuttgart.sw1.klausur.angebot;

/**
 * Demo zur Verwendung der Klasse {@link Konto}. Beachten Sie bitte die
 * zugehörigen Junit Tests.
 *
 */
public class DummyZinsen {

	public static void main(String[] args) {
		
		final Konto konto = new Konto(100, 1.0, 10); // Start mit 100€, Guthabenzins 1%, Sollzins 10%
		
      konto.neuesJahr(100); // Verzinsung des bisherigen Betrags und Aufstockung um 100€ 
      konto.neuesJahr(200, 2.0, 8); // Verzinsung des bisherigen Betrags, Aufstockung um 200€, Änderung der Zinssätze für das Folgejahr. 
      konto.neuesJahr(-500);// Verzinsung des bisherigen Betrags, Abbuchung von 500€ 
		
		System.out.println(konto.getJournal());// Ausgabe des Journals
	}

}
