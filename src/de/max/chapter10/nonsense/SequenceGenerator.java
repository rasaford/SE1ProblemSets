package de.max.chapter10.nonsense;

public interface SequenceGenerator {

	// needs to return a number between min inclusive and max exclusive

	public int getNext(int min, int max);
}
