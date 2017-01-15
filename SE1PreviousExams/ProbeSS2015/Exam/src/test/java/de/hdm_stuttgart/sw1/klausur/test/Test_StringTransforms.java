package de.hdm_stuttgart.sw1.klausur.test;

import static de.hdm_stuttgart.sw1.klausur.StringTransforms.chinesischerAkzent;
import static de.hdm_stuttgart.sw1.klausur.StringTransforms.entferneVokale;
import static de.hdm_stuttgart.sw1.klausur.StringTransforms.morsen;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.hdm_stuttgart.mi.exam.unitmarking.Marking;

@SuppressWarnings({"javadoc"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_StringTransforms {

   // Kill test if lasting longer than 1000 milliseconds
   // @Rule
   // public Timeout globalTimeout = Timeout.seconds(1);

	// Tests zu chinesischerAkzent(final String input)
	//
	@Test
	public void test_010_chinesischerAkzent_EmptyString () {
		Assert.assertEquals("", chinesischerAkzent(""));
	}

	@Test
	@Marking(points=2)
	public void test_020_chinesischerAkzent_Identisch() {
		final String ohne_r_buchstaben = "Es geht auch ohne!";
		Assert.assertEquals(ohne_r_buchstaben, chinesischerAkzent(ohne_r_buchstaben));
	}

	@Test
	@Marking(points=2)
	public void test_030_chinesischerAkzent_Multiple() {
		Assert.assertEquals("Almes Lumänien", chinesischerAkzent("Armes Rumänien"));
	}

	// Tests zu entferneVokale(final String input)
	//
	@Test
	@Marking(points=4)
	public void test_040_entferneVokale_NullInput () {
		Assert.assertNull(entferneVokale(null));
	}

	@Test
	@Marking(points=2)
	public void test_050_entferneVokale_EmptyString() {
		Assert.assertEquals("", entferneVokale(""));
	}

	@Test
	public void test_060_entferneVokale_Einzelvokal() {
		Assert.assertEquals("", entferneVokale("E"));
	}

	@Test
	public void test_070_entferneVokale_Einzelkonsonant() {
		Assert.assertEquals("k", entferneVokale("k"));
	}

	@Test
	@Marking(points=2)
	public void test_080_entferneVokale_NixZuTun () {
		final String textOhneVokale = "dffGl1883KQW_+";
		Assert.assertEquals(textOhneVokale, entferneVokale(textOhneVokale));
	}

	@Test
	@Marking(points=5)
	public void test_090_entferneVokale_Multiple(){
		Assert.assertEquals("Bssr chtng f lls!", entferneVokale("Besser Achtung auf alles!"));
	}

	// Tests zu morsen(final String input)
	//
	@Test
	public void test_100_morsen_Leer () {
		Assert.assertEquals("", morsen(""));
	}

	@Test
	@Marking(points=2)
	public void test_110_morsen_Abend () {
		Assert.assertEquals(".- -... . -. -.. ", morsen("Abend"));
	}
}