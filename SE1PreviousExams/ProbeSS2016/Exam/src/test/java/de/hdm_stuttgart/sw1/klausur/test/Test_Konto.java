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
import de.hdm_stuttgart.sw1.klausur.angebot.Konto;

@SuppressWarnings({ "javadoc" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Konto {

	// Kill test if tests last longer than 1000 milliseconds unless in debugging mode
	@Rule
	public final TestRule timeout = new DisableOnDebug(Timeout.millis(1000));

	
   @Test
   @Marking(points=2)
   public void test_200_NeuesKonto() {
      final Konto konto = new Konto(100, 1, 10);
      Assert.assertEquals(100, konto.getKontostand(), 1.e-6);
   }
   
   @Test
   @Marking(points=1)
   public void test_210_NeuesKontoJournal() {
      final Konto konto = new Konto(100, 1, 10);
      Assert.assertEquals("Jahr 0, Kontostand=100, verzinsung=1.0%\n", konto.getJournal());
   }
   
   @Test
   @Marking(points=3)
   public void test_220_einJahrPositiv() {
      final Konto konto = new Konto(100, 1, 10);
      konto.neuesJahr(100);
      Assert.assertEquals(100 + 100*(1 + 1./100), konto.getKontostand(), 1.e-6);
   }

   @Test
   @Marking(points=2)
   public void test_240_einJahrNegativ() {
      final Konto konto = new Konto(-100, 1, 10);
      konto.neuesJahr(100);
      Assert.assertEquals(-100*(1 + 10./100) + 100, konto.getKontostand(), 1.e-6);
   }

   @Test
   @Marking(points=2)
   public void test_250_einJahrJournal() {
      final Konto konto = new Konto(-100, 1, 10);
      konto.neuesJahr(100);
      Assert.assertEquals(
            "Jahr 0, Kontostand=-100, verzinsung=-10.0%\n" +
            "Jahr 1, Kontostand=-10, verzinsung=-10.0%\n", 
            konto.getJournal());
   }

   @Test
   @Marking(points=4)
   public void test_260_zweiJahre() {
      final Konto konto = new Konto(100, 1, 10);
      konto.neuesJahr(200, 2, 12);
      konto.neuesJahr(100);
      Assert.assertEquals((100 *(1 + 1./100) + 200) * (1 + 2./100) + 100, konto.getKontostand(), 1.e-6);
   }

   @Test
   @Marking(points=4)
   public void test_280_zweiJahrePlusMinus() {
      final Konto konto = new Konto(100, 1, 10);
      konto.neuesJahr(-200);
      konto.neuesJahr(100);
      Assert.assertEquals((100 *(1 + 1./100) - 200)*(1 + 10./100) + 100, konto.getKontostand(), 1.e-6);
   }

   @Test
   @Marking(points=2)
   public void test_300_zweiJahrePlusMinusJournal() {
      final Konto konto = new Konto(100, 1, 10);
      konto.neuesJahr(-200);
      konto.neuesJahr(100);
      System.out.println(konto.getJournal());
      Assert.assertEquals(
            "Jahr 0, Kontostand=100, verzinsung=1.0%\n" +
            "Jahr 1, Kontostand=-99, verzinsung=-10.0%\n" +
            "Jahr 2, Kontostand=-9, verzinsung=-10.0%\n", 
            konto.getJournal());
   }

}