package de.hdm_stuttgart.sw1.klausur.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;

//import de.hdm_stuttgart.mi.bitte_ignorieren.Marking;
import static de.hdm_stuttgart.sw1.klausur.Helper.*;

@SuppressWarnings({"javadoc"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Helper {
   
   // Kill test if lasting longer than 1000 milliseconds
   // i.e. in case of infinite loops or recursion.
   // @Rule 
   // public Timeout globalTimeout = Timeout.seconds(1);

	// Abschnitt getHaeufigkeit
	@Test
	public void test_000_getHaeufigkeitNullBehandlung () {
		Assert.assertEquals(
				0, 
				getHaeufigkeit(3, null));
	}

	@Test
	public void test_010_getHaeufigkeitLeerBehandlung () {
		Assert.assertEquals(
				0, 
				getHaeufigkeit(3, new int[]{}));
	}

	@Test
	public void test_020_getHaeufigkeitEinzelnPositiv () {
		Assert.assertEquals(
				1, 
				getHaeufigkeit(3, new int[]{3}));
	}

	@Test
	public void test_030_getHaeufigkeitDreiLinks() {
		Assert.assertEquals(
				1, 
				getHaeufigkeit(2, new int[]{2, -1, 5}));
	}

	@Test
	public void test_040_getHaeufigkeitDreiMitte() {
		Assert.assertEquals(
				1, 
				getHaeufigkeit(2, new int[]{-1, 2, 15}));
	}

	@Test
	public void test_045_getHaeufigkeitDreiRechts() {
		Assert.assertEquals(
				1, 
				getHaeufigkeit(2, new int[]{-1, -1, 2}));
	}

	@Test
	public void test_050_getHaeufigkeitDreiAlle() {
		Assert.assertEquals(
				3, 
				getHaeufigkeit(2, new int[]{2, 2, 2}));
	}

	@Test
	public void test_060_getHaeufigkeitZehn() {
		Assert.assertEquals(
				5, 
				getHaeufigkeit(2, new int[]{2, 2, 2, -1, 5, 77, 22, 2, 11, 2}));
	}
	
	// Abschnitt getErstenPaarIndex
	
	
	@Test
	public void test_070_getErstenPaarIndexLeer() {
		Assert.assertTrue(getErstenGruppenIndex( new int[]{}) < 0);
	}

	@Test
	public void test_080_getErstenPaarIndexSingle() {
		Assert.assertTrue(getErstenGruppenIndex( new int[]{3}) < 0);
	}

	@Test
	public void test_090_getErstenPaarIndexZweiNegativ() {
		Assert.assertTrue(getErstenGruppenIndex( new int[]{3, -1}) < 0);
	}

	@Test
	public void test_100_getErstenPaarIndexZweiPositiv() {
		Assert.assertEquals(0, getErstenGruppenIndex( new int[]{-4, -4}));
	}

	@Test
	public void test_110_getErstenPaarIndexA() {
		Assert.assertTrue(getErstenGruppenIndex( new int[]{1, 2, 3, 4, 3, 2, 1}) < 0);
	}

	@Test
	public void test_120_getErstenPaarIndexB() {
		Assert.assertEquals(2, getErstenGruppenIndex( new int[]{-4, 2, 3, 3, 3, -1, 7, 4, 4, 5}));
	}

	@Test
	public void test_130_getHaeufigkeitEinsPositiv() {
		Assert.assertEquals(1, getZeichenHaeufigkeit('a', "Ein Anton"));
	}
	
	@Test
	public void test_140_getHaeufigkeitEinsNegativ() {
		Assert.assertEquals(0, getZeichenHaeufigkeit('a', "Nix geht!"));
	}
	
	@Test
	public void test_150_getHaeufigkeitMehrfach() {
			Assert.assertEquals(4, getZeichenHaeufigkeit('b', "Bald bleibt alles beim Alten!"));
	}
	
	// Abschnitt schnittmenge
	@Test
	public void test_160_schnittmengeLeer1() {
			Assert.assertArrayEquals(
					new String[]{}, 
					schnittmenge(new String[]{}, new String[]{}));
	}
		
	@Test
	public void test_170_schnittmengeLeer2() {
			Assert.assertArrayEquals(
					new String[]{}, 
					schnittmenge(new String[]{"Bau"}, new String[]{"Urlaub", "Klausur", "Haus", "Esel"}));
	}
		
	@Test
	public void test_180_schnittmenge() {
			Assert.assertArrayEquals(
					new String[]{"Haus"}, 
					schnittmenge(new String[]{"Haus", "laufen"}, new String[]{"Urlaub", "Klausur", "Haus", "Esel"}));
	}
		
	@Test
	public void test_190_schnittmengeAll() {
		final String[] menge = new String[]{"eins", "zwei", "drei", "vier"};
			Assert.assertArrayEquals(
					menge, 
					schnittmenge(menge, menge));
	}		
}