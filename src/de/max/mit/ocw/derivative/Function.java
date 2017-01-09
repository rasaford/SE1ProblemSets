package de.max.mit.ocw.derivative;

import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 09.01.17.
 */
public class Function {
	private Operation operation;
	private List<Object> operands;

	public Function(Operation operation, Object... operands) {
		this.operation = operation;
		this.operands = Arrays.asList(operands);
	}

	public Function(Object... operands) {
		this.operation = Operation.NULL;
		this.operands = Arrays.asList(operands);
	}

	public Operation getOperation() {
		return operation;
	}

	public List<Object> getOperands() {
		return operands;
	}

	@Override
	public String toString() {
		String op = (operation == null) ? "" : operation.toString();
		return "(" + op + " " + operands  + ")";
	}
}
