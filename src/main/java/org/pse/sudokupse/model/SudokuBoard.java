package org.pse.sudokupse.model;

public class SudokuBoard implements Board{

	private final BoardPrinter boardPrinter;
	private final int[] puzzle;
	
	public SudokuBoard(int[] puzzle, BoardPrinter boardPrinter){
		this.boardPrinter = boardPrinter;
		this.puzzle = puzzle;
	}
	
	public void print(){
		boardPrinter.print(this);
	}

	public int[] getPuzzle() {
		return puzzle;
	}
}
