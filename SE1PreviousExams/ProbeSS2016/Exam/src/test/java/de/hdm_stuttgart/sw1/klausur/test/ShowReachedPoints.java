package de.hdm_stuttgart.sw1.klausur.test;

import de.hdm_stuttgart.mi.exam.unitmarking.RunTests;

public class ShowReachedPoints {

   /**
    * Execution reveals the number of reached points.
    * 
    * @param args Unused
    */
   public static void main(String[] args) {
      RunTests.exec(Test_Helper.class, Test_Konto.class);
   }
}
