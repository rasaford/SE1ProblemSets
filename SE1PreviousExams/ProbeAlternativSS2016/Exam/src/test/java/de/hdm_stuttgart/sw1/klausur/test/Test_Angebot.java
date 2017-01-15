package de.hdm_stuttgart.sw1.klausur.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import de.hdm_stuttgart.mi.exam.unitmarking.Marking;
import de.hdm_stuttgart.sw1.klausur.angebot.Angebot;

@SuppressWarnings({ "javadoc" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Angebot {

	// Kill test if tests last longer than 1000 milliseconds unless in debugging mode
	@Rule
	public final TestRule timeout = new DisableOnDebug(Timeout.millis(1000));

	/**
	 * Tests zu {@link Angebot#Angebot(int)} und {@link Angebot#getGesamtKosten()}
	 */
	@Test
   @Marking(points=3)
	public void test_200_konstruktorKosten() {
		
		final int preisProKilometer = 2;
		final Angebot angebot = new Angebot(preisProKilometer);

		final int anzahlFahrten = 3, kilometer = 5;
		angebot.addiereAnfahrt(anzahlFahrten, kilometer);
		
		Assert.assertEquals(
				anzahlFahrten * kilometer * preisProKilometer,
				angebot.getGesamtKosten());
	}

	@Test
   @Marking(points=3)
	public void test_210_konstruktorDetails() {
		
		final int preisProKilometer = 2;
		final Angebot angebot = new Angebot(preisProKilometer);

		final int anzahlFahrten = 3, kilometer = 5;
		angebot.addiereAnfahrt(anzahlFahrten, kilometer);
		
		Assert.assertEquals(
				"3 x  Anfahrt 5 Km: 30€" + "\n" +
                "Summe: 30€",
                angebot.getAngebotDetails());
	}

	/**
	 * Tests zu {@link Angebot#addiereRaum(int, int, int, int)}
	 */
	@Test
   @Marking(points=4)
	public void test_220_einRaumKosten() {

		final Angebot angebot = new Angebot(12345);

		final int laenge = 5, breite = 3, preisProQuadratmeter = 11, preisProMeter = 2;
		angebot.addiereRaum(laenge, breite, preisProQuadratmeter, preisProMeter);

		Assert.assertEquals(
				laenge * breite * preisProQuadratmeter + 2 * preisProMeter * (laenge + breite),
				angebot.getGesamtKosten());
	}

	@Test
   @Marking(points=2)
	public void test_230_einRaumDetails() {

		final Angebot angebot = new Angebot(12345);

		final int laenge = 5, breite = 3, preisProQuadratmeter = 11, preisProMeter = 2;
		angebot.addiereRaum(laenge, breite, preisProQuadratmeter, preisProMeter);

		Assert.assertEquals(
				"Raum 5 x 3: 197€"+ "\n" +
		        "Summe: 197€",
		        angebot.getAngebotDetails());
	}
	
	@Test
   @Marking(points=6)
	public void test_240_2RaeumeUndAnfahrtKosten() {

		final int preisProKilometer = 1;
		final Angebot angebot = new Angebot(preisProKilometer);

		final int laenge1 = 5, breite1 = 3, preisProQuadratmeter1 = 17, preisProMeter1 = 3;
		angebot.addiereRaum(laenge1, breite1, preisProQuadratmeter1, preisProMeter1);

		final int laenge2 = 8, breite2 = 1, preisProQuadratmeter2 = 13, preisProMeter2 = 2;
		angebot.addiereRaum(laenge2, breite2, preisProQuadratmeter2, preisProMeter2);

		final int anzahlFahrten = 7, kilometer = 19;
		angebot.addiereAnfahrt(anzahlFahrten, kilometer);
		
		Assert.assertEquals(
				laenge1 * breite1 * preisProQuadratmeter1 + 2 * preisProMeter1 * (laenge1 + breite1) +
				laenge2 * breite2 * preisProQuadratmeter2 + 2 * preisProMeter2 * (laenge2 + breite2) +
				anzahlFahrten * kilometer * preisProKilometer,
				angebot.getGesamtKosten());
	}
	
	@Test
   @Marking(points=2)
	public void test_250_2RaeumeUndAnfahrtDetails() {

		final int preisProKilometer = 1;
		final Angebot angebot = new Angebot(preisProKilometer);

		final int laenge1 = 5, breite1 = 3, preisProQuadratmeter1 = 17, preisProMeter1 = 3;
		angebot.addiereRaum(laenge1, breite1, preisProQuadratmeter1, preisProMeter1);

		final int laenge2 = 7, breite2 = 2, preisProQuadratmeter2 = 17, preisProMeter2 = 2;
		angebot.addiereRaum(laenge2, breite2, preisProQuadratmeter2, preisProMeter2);

		final int anzahlFahrten = 7, kilometer = 19;
		angebot.addiereAnfahrt(anzahlFahrten, kilometer);
		
		Assert.assertEquals(
				"Raum 5 x 3: 303€" + "\n" +
                "Raum 7 x 2: 274€" + "\n" +
			    "7 x  Anfahrt 19 Km: 133€" + "\n" +
                "Summe: 710€",
                angebot.getAngebotDetails());
	}
}