package test;

public class LongToInt {
	public static void main(String[] args) {
		
		final long Val = 28100000220000001L;
		final int redVal = (int) (Val / (2L * (Integer.MAX_VALUE + 1L)));
				
		System.out.println(redVal);
		
	}

}
