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
	 * Tests zu {@link Helper#maxMindestensNull(int, int)}
	 */
	@Test
	@Marking(points = 3)
	public void test_080_maxMindestensNull_positiv() {
		Assert.assertEquals(3, maxMindestensNull(1, 3));
		Assert.assertEquals(3, maxMindestensNull(3, 1));
	}

	@Test
	@Marking(points = 2)
	public void test_090_maxMindestensNull_negativ() {
		Assert.assertEquals(0, maxMindestensNull(-1, -3));
		Assert.assertEquals(0, maxMindestensNull(-3, -1));
	}

	@Test
	@Marking(points = 2)
	public void test_100_maxMindestensNull_gemischt() {
		Assert.assertEquals(5, maxMindestensNull(-1, 5));
		Assert.assertEquals(5, maxMindestensNull(5, -1));
	}

	@Test
	@Marking(points = 2)
	public void test_100_maxMindestensNull_gemischt2() {
		Assert.assertEquals(0, maxMindestensNull(-1, 0));
		Assert.assertEquals(0, maxMindestensNull(0, -4));
		Assert.assertEquals(0, maxMindestensNull(0, 0));
	}

	/**
	 * Tests zu {@link Helper#getUmgekehrteReihenfolge(String)}
	 */
	@Test
	@Marking(points = 3)
	public void test_110_getUmgekehrteReihenfolge() {
		Assert.assertTrue("Test dieser ist Gut".equals(getUmgekehrteReihenfolge("Gut ist dieser Test")));
	}

	@Test
	@Marking(points = 2)
	public void test_115_getUmgekehrteReihenfolge() {
		Assert.assertTrue("Worte drei Nur".equals(getUmgekehrteReihenfolge("Nur drei Worte")));
	}

	@Test
	@Marking(points = 2)
	public void test_120_getUmgekehrteReihenfolge() {
		Assert.assertTrue("Test".equals(getUmgekehrteReihenfolge("Test")));
	}

	@Test
	@Marking(points = 2)
	public void test_130_getUmgekehrteReihenfolge() {
		Assert.assertEquals(null, getUmgekehrteReihenfolge(null));
	}

	/**
	 * Tests zu {@link Helper#capitalize(String)}
	 */
	@Test
	@Marking(points = 2)
	public void test_150_capitalize() {
		Assert.assertEquals("Source Code Kennt Das Konzept Des CamelCase", capitalize("source Code kennt das Konzept des CamelCase"));
	}

	@Test
	@Marking(points = 3)
	public void test_155_capitalize() {
		Assert.assertEquals("Miles O'Brien", capitalize("miles o'Brien"));
	}

	@Test
	@Marking(points = 2)
	public void test_160_capitalize() {
		Assert.assertEquals("Das Kunstwort Just4all", capitalize("Das Kunstwort just4all"));
	}

	@Test
	@Marking(points = 2)
	public void test_165_capitalize() {
		Assert.assertEquals("", capitalize(""));
	}

	@Test
	@Marking(points = 2)
	public void test_167_capitalize() {
		Assert.assertEquals(null, capitalize(null));
	}

	@Test
	@Marking(points = 2)
	public void test_169_capitalize() {
		Assert.assertEquals("A", capitalize("a"));
		Assert.assertEquals("A", capitalize("A"));
	}

	@Test
	@Marking(points = 2)
	public void test_172_capitalize() {
		Assert.assertEquals(".", capitalize("."));
		Assert.assertEquals("2", capitalize("2"));
		Assert.assertEquals("4all", capitalize("4all"));
	}

	/**
	 * Tests zu {@link Helper#parseIntOhneAusnahme(String)}
	 */
	@Test
	@Marking(points = 2)
	public void test_180_parseIntOhneAusnahme_positiv() {
		Assert.assertEquals(42, parseIntOhneAusnahme("42"));
		Assert.assertEquals(-42, parseIntOhneAusnahme("-42"));
	}

	@Test
	@Marking(points = 3)
	public void test_190_parseIntOhneAusnahme_negativ() {
		Assert.assertEquals(0, parseIntOhneAusnahme("Geht nicht!"));
		Assert.assertEquals(0, parseIntOhneAusnahme("4.3"));
		Assert.assertEquals(0, parseIntOhneAusnahme(""));
	}

	@Test
	@Marking(points = 2)
	public void test_200_parseIntOhneAusnahme_null() {
		Assert.assertEquals(0, parseIntOhneAusnahme(null));
	}

	/**
	 * Tests zu {@link Helper#zyklischRechtsRotieren(int[])}
	 */
	@Test
	@Marking(points = 1)
	public void test_220_zyklischRechtsRotieren_null() {
		final int[] in = new int[]{};
		zyklischRechtsRotieren(in);
		Assert.assertArrayEquals(new int[]{}, in);
	}

	@Test
	@Marking(points = 1)
	public void test_230_zyklischRechtsRotieren_leer() {
		final int[] in = new int[]{};
		zyklischRechtsRotieren(in);
		Assert.assertArrayEquals(new int[]{}, in);
	}

	@Test
	@Marking(points = 1)
	public void test_240_zyklischRechtsRotieren_eins() {
		final int[] in = new int[]{1};
		zyklischRechtsRotieren(in);
		Assert.assertArrayEquals(new int[]{1}, in);
	}

	@Test
	@Marking(points = 3)
	public void test_250_zyklischRechtsRotieren_zwei() {
		final int[] in = new int[]{7, 8},
				expected = new int[]{8, 7};
		zyklischRechtsRotieren(in);
		Assert.assertArrayEquals(expected, in);
	}

	@Test
	@Marking(points = 4)
	public void test_260_zyklischRechtsRotieren_sieben() {
		final int[] in = new int[]{7, 6, 5, 4, 3, 2, 1},
				expected = new int[]{1, 7, 6, 5, 4, 3, 2};
		zyklischRechtsRotieren(in);
		Assert.assertArrayEquals(expected, in);
	}
}