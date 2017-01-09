package test;

public class CompoundInterest {
	public static void main(String[] args) {
		
		final double initCap = 223.12;
		final double intRate = 1.5;
		
		int years = 3;
		double nYears = initCap;
		
		for (int i = 1; i <= years; i++) {
			nYears *= intRate * 0.01 + 1.0;
		}
		
		System.out.println("Inital Capital: " 			+ initCap);
		System.out.println("Annual Interest: " 			+ intRate);
		System.out.println("Capital after three years: "+ nYears);

	
	}

}
