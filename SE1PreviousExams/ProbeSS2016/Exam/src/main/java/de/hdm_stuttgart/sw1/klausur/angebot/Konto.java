package de.hdm_stuttgart.sw1.klausur.angebot;

/**
 * <p>Verzinsung von Guthaben oder Schulden. Es gelten folgende Regeln:</p>
 * <p>
 * <p>Einmal pro Jahr kann über eine der beiden Methoden  {@link #neuesJahr(double, double, double)} oder {@link #neuesJahr(double)}
 * gemäß Vorzeichen des Betrags eingezahlt oder abgehoben werden.</p>
 * <p>
 * <p>Gleichzeitig können zu diesem Zeitpunkt die Zinssätze für Guthaben und Schulden (Soll) für das Folgejahr angepasst werden.</p>
 */
public class Konto {

	private double kontostand;
	private double guthabenZins;
	private double sollZins;
	private long jahr = 0;
	private StringBuilder journal = new StringBuilder();

	/**
	 * Erstelle neues Konto.
	 *
	 * @param kontostand   Initialer Kontostand.
	 * @param guthabenZins Initialer Guthabenzins.
	 * @param sollZins     Initialer Schuldzins.
	 */
	public Konto(double kontostand, double guthabenZins, double sollZins) {
		this.kontostand = kontostand;
		this.guthabenZins = guthabenZins;
		this.sollZins = sollZins;
		updateJournal();
	}

	/**
	 * Diese oder alternativ die Methode {@link #neuesJahr(double)} wir einmal jährlich
	 * <p>
	 * <ul>
	 * <li>Durchführung der Verzinsung für das zurückliegende Jahr zu aktuellen Guthaben- bzw. Schuldzinsen.</li>
	 * <li>Einzahlung für das jeweils nächste Jahr</li>
	 * <li>Anpassung von Guthaben- und Schuldzins für das kommende Verzinsungsjahr.</li>
	 * </ul>
	 * ,  und .
	 *
	 * @param betrag       Je nach Vorzeichen neu hinzugefügter oder abgebuchter Betrag.
	 * @param guthabenZins Der für das jeweils kommende Jahr geltende prozentuale Guthabenzins für nichtnegative Kontostände.
	 * @param sollZins     Der für das jeweils kommende Jahr geltende prozentuale Guthabenzins für negative Kontostände.
	 *                     <p>
	 *                     <p style="color: red;font-weight: bold;">Tip: Im Hinblick auf das Journal in {@link #getJournal()} können Sie alle
	 *                     benötigten Informationen in einer {@link StringBuffer} Instanzvariablen sammeln. Sinngemäß gilt dies auch für den jeweils
	 *                     aktuellen Kontostand.</p>
	 */
	public void neuesJahr(double betrag, double guthabenZins, double sollZins) {
		neuesJahr(betrag);
		this.sollZins = sollZins;
		this.guthabenZins = guthabenZins;
	}

	/**
	 * Wie {@link #neuesJahr(double, double, double)} allerdings ohne Änderung von Guthaben- und Sollzins für
	 * das kommende Verzinsungsjahr.
	 *
	 * @param betrag Je nach Vorzeichen neu hinzugefügter oder abgebuchter Betrag.
	 */
	public void neuesJahr(double betrag) {
		this.kontostand *= (kontostand < 0) ? ((sollZins / 100) + 1) : ((guthabenZins / 100) + 1);
		this.kontostand += betrag;
		updateJournal();
	}

	/**
	 * @return Der aktuelle Kontostand.
	 */
	public double getKontostand() {
		return this.kontostand;
	}

	/**
	 * Die Entwicklung der Kontostände kaufmännisch auf ganzzahlige Werte gerundet. Für das Beispiel {@link DummyZinsen#main(String[])} ergibt sich:
	 * <p>
	 * <pre>Jahr 0, Kontostand=100, verzinsung=1.0%
	 * Jahr 1, Kontostand=201, verzinsung=1.0%
	 * Jahr 2, Kontostand=403, verzinsung=2.0%
	 * Jahr 3, Kontostand=-89, verzinsung=-8.0%</pre>
	 *
	 * @return Ausdruckbarer Verlauf der Kontoentwicklung
	 * <p>
	 * <ul>
	 * <li><p style="color: red;font-weight: bold;">Tip: Im Hinblick auf das Journal in {@link #getJournal()} können Sie alle
	 * benötigten Informationen in einer {@link StringBuffer} Instanzvariablen sammeln. Sinngemäß gilt dies auch für den jeweils
	 * aktuellen Kontostand. Beachten Sie die Methode {@link Math#round(double)}</p></li>
	 * <p>
	 * <li><p style="color: red;font-weight: bold;">Tip: Ein Hang zum Erbsenzählen erleichtert die Lösung.
	 * Bereits ein falsches Leer- oder fehlendes Newline Zeichen (auch am Ende!)
	 * lässt die zugehörigen Tests scheitern. Beachten Sie allfällige Junit Fehlermeldungen sehr genau.</p></li>
	 * <p>
	 * </ul>
	 */
	public String getJournal() {
		return journal.toString();
	}

	private void updateJournal() {
		journal.append("Jahr " + this.jahr++ + ", Kontostand=" + Math.round(kontostand) + ", verzinsung=" +
				((kontostand < 0) ? -this.sollZins : this.guthabenZins) + "%\n");
	}
}