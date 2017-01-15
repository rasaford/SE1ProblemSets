package de.hdm_stuttgart.sw1.klausur.angebot;

import java.util.Formatter;

/**
 * Erstellung von Angeboten für Dienstleistungen eines Handwerksbetriebs. Erfaßt werden:
 * <p>
 * <ul>
 * <li>Bodenverlegung in Räumen: Kosten für Boden und Fußleisten</li>
 * <li>Berücksichtigung der Anzahl von Anfahrtswegen</li>
 * </ul>
 * <p>
 * <p>Im Hinblick auf den Kostenanteil für Anfahrtswege wird der Kilometerpreis über den Konstruktor
 * des jeweiligen Angebots festgelegt.</p>
 */
public class Angebot {
	private double costPerKm;
	private double totalCost;
	StringBuilder log = new StringBuilder();

	/**
	 * @param kostenProKilometer Kosten pro Kilometer Anfahrtsweg.
	 */
	public Angebot(int kostenProKilometer) {
		costPerKm = kostenProKilometer;
	}

	/**
	 * Kosten für die Bodenverlegung in einem einzelnen, rechteckigen Raum. Diese ergeben sich einerseits aus der Fläche des verlegten Bodens über den Preis pro Quadratmeter.
	 * Andererseits bestimmt der Umfang des Raumes die Länge der benötigten Bodenleisten, welche über den Preis pro Meter zu den Kosten beiträgt.
	 *
	 * @param laenge               Länge des Raums
	 * @param breite               Breite des Raums
	 * @param preisProQuadratmeter Kosten des gewählten Bodens (Laminat, Parkett,...) pro Quadratmeter.
	 * @param preisProMeter        Kosten für die gewählte Art der Fußleiste pro Meter. Türaussparungen etc. werden vernachlässigt.
	 *                             <p>
	 *                             <p style="color: red;font-weight: bold;">Tip: Im Hinblick auf die Ausgabe der Angebotsdetails in {@link #getAngebotDetails()} können Sie alle benötigten Informationen
	 *                             in einer {@link StringBuffer} Instanzvariablen sammeln. Sinngemäß gilt dies auch für die Gesamtkosten.</p>
	 */
	public void addiereRaum(int laenge, int breite, int preisProQuadratmeter, int preisProMeter) {
		double cost = laenge * breite * preisProQuadratmeter + 2 * (laenge + breite) * preisProMeter;
		log.append((new Formatter()).format("Raum %d x %d: %d€\n", laenge, breite, (int) cost));
		totalCost += cost;
	}

	/**
	 * Kosten für eine oder mehrere Anfahrten. Der Preis pro Kilometer wird bereits im Konstruktor {@link #Angebot(int)} festgelegt.
	 *
	 * @param anzahl    Anzahl benötigter Anfahrten
	 * @param kilometer Entfernung pro Anfahrt.
	 *                  <p>
	 *                  <p style="color: red;font-weight: bold;"> Tip: Im Hinblick auf die Ausgabe der Angebotsdetails in {@link #getAngebotDetails()} können Sie alle benötigten Informationen
	 *                  in einer (weiteren) {@link StringBuffer} Instanzvariablen sammeln. Sinngemäß gilt dies auch für die Gesamtkosten.</p>
	 */
	public void addiereAnfahrt(int anzahl, int kilometer) {
		double cost = anzahl * kilometer * costPerKm;
		log.append((new Formatter()).format("%d x  Anfahrt %d Km: %d€\n", anzahl, kilometer, (int) cost));
		totalCost += cost;
	}

	/**
	 * Die Kosten ergeben sich durch alle vorherigen Aufrufe von {@link #addiereRaum(int, int, int, int)} und {@link #addiereAnfahrt(int, int)} in Verbindung
	 * mit dem im Konstruktor {@link #Angebot(int)} festgesetzten Kilometerpreis.
	 *
	 * @return Kosten für Bodenverlegung und Anfahrt
	 */
	public int getGesamtKosten() {
		return (int) Math.round(totalCost);
	}

	/**
	 * Die Angebotsdetails ergeben sich durch alle vorherigen Aufrufe von {@link #addiereRaum(int, int, int, int)} und {@link #addiereAnfahrt(int, int)} in Verbindung
	 * mit dem im Konstruktor {@link #Angebot(int)} festgesetzten Kilometerpreis. Die Testapplikation {@link DummyAngebot#main(String[])} erzeugt eine typische Ausgabe:
	 * <p>
	 * <pre><code>Raum 2 x 4: 172€
	 * Raum 3 x 5: 439€
	 * 3 x  Anfahrt 44 Km: 264€
	 * Summe: 875€</code></pre>
	 *
	 * @return Erläuternder Angebotstext zum Ausdrucken
	 * <p>
	 * <p  style="color: red;font-weight: bold;">Tip: Für das korrekte Zusammenbasteln des Texts ist eine Veranlagung zum Erbsenzählen hilfreich:
	 * Bereits ein falsches Leerzeichen lässt alle Tests scheitern. Schauen Sie sich bei Fehlern die Ausgabe der Junit Tests <b>sehr genau</b> an.</p>
	 */
	public String getAngebotDetails() {
		log.append((new Formatter()).format("Summe: %d€", (int) totalCost));
		return log.toString();
	}


}