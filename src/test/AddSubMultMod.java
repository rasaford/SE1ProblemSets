package test;

public class AddSubMultMod {
	public static void main(String[] args) {
		System.out.println(
				"Behold the power of the calculator;");
		int a = 10,
			b = 69;
		int result = -1;
		String method = "mod";
		
		System.out.println("a=" +a);
		System.out.println("b=" +b);
		
		if (method == "add") {
			result = a + b;
		} else if (method == "sub") {
			result = a - b;
		} else if (method == "mult") {
			result = a * b;
		} else if (method == "mod") {
			result = a % b;
		}
		
		System.out.println("method: " + method + "\n"
				+ "result = " + result);
	}
	
}