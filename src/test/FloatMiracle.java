package test;

public class FloatMiracle {
	public static void main(String[] args) {
		
		  final double a = 0.7;
		  final double b = 0.9;
		  final double x = a + 0.1;
		  final double y = b - 0.1;
		  System.out.println(x);
		  System.out.println(y);
		  System.out.println(Math.abs(x - y) < 1.e-14);

	}
}
