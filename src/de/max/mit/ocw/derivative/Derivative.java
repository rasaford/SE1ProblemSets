package de.max.mit.ocw.derivative;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 09.01.17.
 */
public class Derivative {

	public static Function derivate(Function function, String var) {
		if (constant(function, var))
			return new Function("0");
		if (variable(function, var))
			return new Function("1");
		if (function.getOperation().equals(Operation.ADD))
		{
			List<Object> obj = function.getOperands();
			List<Object> out = new ArrayList<>();
			for (Object o : obj) {
				out.add(derivate(new Function(o), var));
			}
			return new Function(Operation.ADD, out);
		}
		return new Function("error");
	}

	private static boolean single(Function f) {
		if (f.getOperation().equals(Operation.NULL)) {
			List<Object> op = f.getOperands();
			if (op.size() == 1 && op.get(0) instanceof String) {
				return true;
			}
		}
		return false;
	}

	private static boolean constant(Function f, String var) {
		if (single(f)) {
			String op = (String) f.getOperands().get(0);
			return !op.contains(var);
		}
		return false;
	}

	private static boolean variable(Function f, String var) {
		if (single(f)) {
			String op = (String) f.getOperands().get(0);
			return op.equals(var);
		}
		return false;
	}
}
