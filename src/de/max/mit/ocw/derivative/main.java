package de.max.mit.ocw.derivative;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by max on 09.01.17.
 */
public class main {
	public static void main(String[] args) {
		Function f = new Function(Operation.ADD, "2", "x", "a");
		System.out.println(f);
		System.out.println(Derivative.derivate(f, "x"));
	}
}
