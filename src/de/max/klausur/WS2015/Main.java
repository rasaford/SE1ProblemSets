package de.max.klausur.WS2015;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by max on 13.01.17.
 */
public class Main {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(1.231231241341),
				b = new BigDecimal(Math.sqrt(2));
		a = a.divide(b, BigDecimal.ROUND_HALF_DOWN);
		System.out.println(BigDecimal.ROUND_UNNECESSARY);
		System.out.println("a = " + a.toEngineeringString());
		System.out.println(Integer.parseInt("7FFFFF", 16));
		System.out.println(String.format("0x%08X", 223));
	}

}

