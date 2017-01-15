package de.hdm_stuttgart.sw1.klausur.angebot;

/**
 * Demo zur Verwendung der Klasse {@link Angebot}. Beachten Sie bitte die
 * zugehörigen Junit Tests.
 *
 */
public class DummyAngebot {

	public static void main(String[] args) {
		
		final int preisProKilometer = 2;
		
		final Angebot angebot = new Angebot(preisProKilometer);
		
		angebot.addiereRaum(2, 4, 17, 3);
		angebot.addiereRaum(3, 5, 25, 4);

		angebot.addiereAnfahrt(3, 44);
		
		System.out.println(angebot.getAngebotDetails());
	}

}
