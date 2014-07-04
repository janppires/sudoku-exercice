package org.pse.sudokupse.model;

public interface Board {
	
	public void print();
	
	public int[] getPuzzle();
	
	public boolean validate(int position, int value);
}
