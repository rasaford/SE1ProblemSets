package de.max.chapter04.MathLibrary;

public class Driver {
	public static void main(String[] arga)
	{
		int a = 6,
			b = 36;
		System.out.println("Gcd: ");
		System.out.format(	"The Gcd of %d and %d is: " 
							+ Math.getGcd(a, b) + "\n", a, b); 
		System.out.println("Common Multiple: ");
		System.out.format(	"The smallest Multiple of %d and %d is: " +
							Math.getCommonMultiple(a, b) +
							"\n", a, b);
		
		double pi = java.lang.Math.PI;
		System.out.println("Sin: ");
		System.out.println( "The sin(" + pi * 10 + ") is: ");
		System.out.print(Math.sinHighPrecision(1250*pi));
	}
}
