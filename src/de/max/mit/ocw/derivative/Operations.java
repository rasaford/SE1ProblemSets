package de.max.mit.ocw.derivative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 09.01.17.
 */
public class Operations {

	public static Function add(Function... functions) {
		List<Object> out = new ArrayList<>();
		for (Function f : functions) {
			if (f.getOperands().size() == 1 && !f.getOperands().get(0).equals("0"))
				out.add(f);
		}
		return new Function(Operation.ADD, Arrays.asList(functions));
	}
}
