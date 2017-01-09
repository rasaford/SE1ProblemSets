package test;

public class BinaryLiterals {
	public static void main(String[] args) {
		int max = 0b01111111_11111111_11111111_11111111,
			min = 0b10000000_00000000_00000000_00000000;
		
		System.out.println("Minimum: " + min);
		System.out.println("Maximum: " + max);
	   
		System.out.println("int minimum:" + Integer.MIN_VALUE);
	    System.out.println("int minimum:" + Integer.MAX_VALUE);
	    
	    System.out.println("int bytes:" + Integer.BYTES);
	    System.out.println("int size:" + Integer.SIZE);
		
	}

}
