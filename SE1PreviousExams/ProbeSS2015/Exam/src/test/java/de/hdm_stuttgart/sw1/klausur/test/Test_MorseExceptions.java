package de.hdm_stuttgart.sw1.klausur.test;

import static de.hdm_stuttgart.sw1.klausur.StringTransforms.morsen;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.hdm_stuttgart.mi.exam.unitmarking.Marking;

@SuppressWarnings({"javadoc"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_MorseExceptions {

   // Kill test if lasting longer than 1000 milliseconds
   // @Rule 
   // public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	@Marking(points=5)
	public void test_010_morsen_Exception () {
		try {
			final String text = "Ab+en_d";
			morsen("Ab+en_d");
			Assert.fail("String " + text + " sollte Exception zur Folge haben");
		} catch (final Exception ex) {}
	}
	
	@Test
	@Marking(points=2)
	public void test_020_morsen_ExceptionMessage() {
		final String text = "Ab+en_d";
		try {
			morsen(text);
			Assert.fail("String " + text + " sollte Exception zur Folge haben");
		} catch (final Exception ex) {
			Assert.assertEquals("Eingabezeichenkette '" + text + 
					"' enthält nicht-Morsezeichen '+'.", ex.getMessage());
		}
	}
}