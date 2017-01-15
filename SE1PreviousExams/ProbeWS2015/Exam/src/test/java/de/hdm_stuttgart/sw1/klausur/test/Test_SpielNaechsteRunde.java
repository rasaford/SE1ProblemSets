package de.hdm_stuttgart.sw1.klausur.test;

import static de.hdm_stuttgart.sw1.klausur.Spielen.getTeilnehmerNaechsteRunde;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.hdm_stuttgart.mi.exam.unitmarking.Marking;

@SuppressWarnings({"javadoc"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_SpielNaechsteRunde  {

   // Kill test if lasting longer than 1000 milliseconds
   // @Rule
   // public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void test_010_nullBehandlung () {
		Assert.assertEquals(
				null, 
				getTeilnehmerNaechsteRunde(null));
	}

	@Test
	public void test_020_einzelnerTeilnehmer () {
		final int[] punkte= {44};
		Assert.assertArrayEquals(
				punkte, 
				getTeilnehmerNaechsteRunde(punkte));
	}
	
	@Test
	public void test_030_zweiSpielerGleich () {
		final int[] punkte= {2, 2};
		Assert.assertArrayEquals(
				punkte, 
				getTeilnehmerNaechsteRunde(punkte));
	}
	
	@Test
	public void test_040_zweiSpielerUngleich () {
		final int[] punkte= {2, 1};
		Assert.assertArrayEquals(
				new int[]{2}, 
				getTeilnehmerNaechsteRunde(punkte));
	}
	
	@Test
	public void test_050_identischerPunktstand () {
		final int[] punkte= {2, 2, 2};
		Assert.assertArrayEquals(
				punkte, 
				getTeilnehmerNaechsteRunde(punkte));
	}
	
	@Test
	public void test_060_dreiSpielerZweiGewinnerLinks () {
		final int[] 
				aktuell = {3, 3, 2},
				naechste= {3, 3} ;
		Assert.assertArrayEquals(naechste, getTeilnehmerNaechsteRunde(aktuell));
	}
	
	@Test
	public void test_070_dreiSpielerZweiGewinnerRechts () {
		final int[] 
				aktuell = {2, 3, 3},
				naechste= {3, 3} ;
		Assert.assertArrayEquals(naechste, getTeilnehmerNaechsteRunde(aktuell));
	}
	
	@Test
	public void test_080_dreiSpielerLinks () {
		final int[] 
				aktuell = {3, 2, 2},
				naechste= {3} ;
		Assert.assertArrayEquals(naechste, getTeilnehmerNaechsteRunde(aktuell));
	}
	
	@Test
	public void test_090_dreiSpielerMitte () {
		final int[] 
				aktuell = {2, 3, 2},
				naechste= {3} ;
		Assert.assertArrayEquals(naechste, getTeilnehmerNaechsteRunde(aktuell));
	}
	
	@Test
	public void test_100_dreiSpielerRechts () {
		final int[] 
				aktuell = {2, 2, 3},
				naechste= {3} ;
		Assert.assertArrayEquals(naechste, getTeilnehmerNaechsteRunde(aktuell));
	}
	
	@Test
	public void test_110_vierSpieler () {
		final int[] 
				aktuell = {1,2,3,2},
				naechste= {3} ;
		Assert.assertArrayEquals(naechste, getTeilnehmerNaechsteRunde(aktuell));
	}
	
	@Test
	@Marking(points=2)
	public void test_120_siebenSpielerDreiGewinner () {
		final int[] 
				aktuell = {5, 1, 1, 2, 1, 1, 5},
				naechste= {5, 2, 5} ;
		Assert.assertArrayEquals(naechste, getTeilnehmerNaechsteRunde(aktuell));
	}
}