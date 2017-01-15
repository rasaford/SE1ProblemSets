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
import de.hdm_stuttgart.sw1.klausur.Helper;

import static de.hdm_stuttgart.sw1.klausur.Helper.*;

@SuppressWarnings({"javadoc"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Helper {

	// Kill test if tests last longer than 1000 milliseconds unless in debugging mode
	@Rule
	public final TestRule timeout = new DisableOnDebug(Timeout.millis(1000));

	/**
	 * Tests zu {@link Helper#klartextName(int)}
	 */
	@Test
	@Marking(points = 3)
	public void test_100_klartext() {
		Assert.assertEquals("sieben", klartextName(7));
	}

	@Test
	@Marking(points = 3)
	public void test_120_klartext() {
		Assert.assertEquals("null", klartextName(0));
	}

	@Test
	@Marking(points = 3)
	public void test_130_klartextNegativ() {
		Assert.assertEquals("Uuups, keine Regel für den Wert -1", klartextName(-1));
		Assert.assertEquals("Uuups, keine Regel für den Wert 13", klartextName(13));
	}

	/**
	 * Tests zu {@link Helper#getProduktBetrag(int, int)}
	 */
	@Test
	@Marking(points = 8)
	public void test_145_produktbetrag() {
		Assert.assertEquals(10, getProduktBetrag(2, 5));
		Assert.assertEquals(110, getProduktBetrag(2, -55));
		Assert.assertEquals(120, getProduktBetrag(-40, 3));
		Assert.assertEquals(21, getProduktBetrag(-3, -7));
	}

	/**
	 * Tests zu {@link Helper#getQuadrant(double)}
	 */
	@Test
	@Marking(points = 8)
	public void test_160_quadrant() {

		for (int i = 0; i < 90; i++) {
			Assert.assertEquals(1, getQuadrant(i));
		}

		for (int i = 90; i < 180; i++) {
			Assert.assertEquals(2, getQuadrant(i));
		}

		for (int i = 180; i < 270; i++) {
			Assert.assertEquals(3, getQuadrant(i));
		}

		for (int i = 270; i < 360; i++) {
			Assert.assertEquals(4, getQuadrant(i));
		}
	}

	/**
	 * Tests zu {@link Helper#getZeitangabe(long)}
	 */
	@Test
	@Marking(points = 8)
	public void test_180_zeitangabe() {
		Assert.assertEquals("0:0:31", getZeitangabe(31));
		Assert.assertEquals("0:2:5", getZeitangabe(125));
		Assert.assertEquals("0:5:1", getZeitangabe(301));
		Assert.assertEquals("0:10:42", getZeitangabe(642));
		Assert.assertEquals("2:0:41", getZeitangabe(7241));
	}

	/**
	 * Tests zu {@link Helper#spiegelung(int[])}
	 */
	@Test
	@Marking(points = 8)
	public void test_200_spiegelung() {
		spiegelung(null); // Sollte keine Exception werfen.

		{
			final int[] input = new int[]{};
			Assert.assertArrayEquals(new int[]{}, spiegelung(input));
		}

		{
			final int[] input = new int[]{1};
			Assert.assertArrayEquals(new int[]{1}, spiegelung(input));
		}

		{
			final int[] input = new int[]{1, 2};
			Assert.assertArrayEquals(new int[]{2, 1}, spiegelung(input));
		}

		{
			final int[] input = new int[]{2, 1};
			Assert.assertArrayEquals(new int[]{1, 2}, spiegelung(input));
		}

		{
			final int[] input = new int[]{-1, 22, -333};
			Assert.assertArrayEquals(new int[]{-333, 22, -1}, spiegelung(input));
		}

		{
			final int[] input = new int[]{-1, 22, -333};
			Assert.assertArrayEquals(new int[]{-333, 22, -1}, spiegelung(input));
		}

		{
			final int[] input = new int[]{-1, 22, -333, 24, 55};
			Assert.assertArrayEquals(new int[]{55, 24, -333, 22, -1}, spiegelung(input));
		}

	}

	/**
	 * Tests zu {@link Helper#istGueltig(String)}
	 */
	@Test
	@Marking(points = 9)
	public void test_240_istGueltig() {
		Assert.assertTrue(istGueltig("0-201-31452-5"));
		Assert.assertTrue(istGueltig("8535902775"));
		Assert.assertTrue(istGueltig("8-535-9027-75"));
		Assert.assertFalse(istGueltig("1843369283"));
		Assert.assertFalse(istGueltig("9-2")); //Just two digits
		Assert.assertFalse(istGueltig("")); //empty
	}

}