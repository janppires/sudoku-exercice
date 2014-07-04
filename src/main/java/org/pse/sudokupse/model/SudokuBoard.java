package org.pse.sudokupse.model;

import java.util.Arrays;
import java.util.List;

public class SudokuBoard implements Board{

	
	public static int MAJOR_SQUARE_SIZE = 9;
	public static int MINOR_SQUARE_SIZE = 3;
	
	private final BoardPrinter boardPrinter;
	private final int[] puzzle;
	
	private static final List<Integer> possibleValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	
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

	public boolean validate(int position, int value) {
		if(!possibleValues.contains(value)){
			throw new IllegalArgumentException("Invalid value: " + value);
		}
		
		if(position >= puzzle.length){
			throw new IllegalArgumentException("Invalid position: " + position);
		}
		
		if(!validateLine(position, value)){
			return false;
		}
		
		if(!validateColumn(position, value)){
			return false;
		}
		
		if(!validateSquare(position, value)){
			return false;
		}
		
		return true;
	}
	
	private boolean validateLine(int position, int value){
	
		int row = getRow(position);
		
		for(int i = 0; i < MAJOR_SQUARE_SIZE; i++){
			if(puzzle[i + row] == value){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean validateColumn(int position, int value){
		
		int column = getColumn(position);
		
		for(int i = 0; i < MAJOR_SQUARE_SIZE; i++){
			if(puzzle[i + column] == value){
				return false;
			}
		}
		
		return true;
	}

	private boolean validateSquare(int position, int value){
	
		int squarePosition = getSquarePosition(position);
		
		for(int column = 0; column < MINOR_SQUARE_SIZE; column++){
			for(int row = 0; ; row+=MAJOR_SQUARE_SIZE){
				if(puzzle[column+row+squarePosition] == value){
					return false;
				}
			}
		}
		
		return true;
	}
	
	private int getSquarePosition(int position){
		//TODO: FALTA ISTO!
		return (position / 6 ) * MAJOR_SQUARE_SIZE;
	}
	
	private int getRow(int position){
		return position / MAJOR_SQUARE_SIZE;
	}
	
	private int getColumn(int position){
		return position % MAJOR_SQUARE_SIZE;
	}
}
