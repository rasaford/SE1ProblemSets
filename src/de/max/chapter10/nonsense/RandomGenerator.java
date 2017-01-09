package de.max.chapter10.nonsense;

import java.util.Random;

public class RandomGenerator implements SequenceGenerator{

	private Random rand = new Random();
	
	@Override
	public int getNext(int min, int max)
	{
		return rand.nextInt(max - min) + min;
	}
}
