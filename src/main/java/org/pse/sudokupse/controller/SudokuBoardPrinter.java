package org.pse.sudokupse.controller;

import org.pse.sudokupse.model.Board;
import org.pse.sudokupse.model.BoardPrinter;

public class SudokuBoardPrinter implements BoardPrinter{

	private static int SIDE_SIZE = 9;
	private static int SEPARATOR_SIZE = 3;
	
	public void print(Board board) {
		int[] puzzle = board.getPuzzle();
		if(puzzle.length != SIDE_SIZE*SIDE_SIZE){
			throw new IllegalArgumentException("Invalid size!");
		}
		
		print(puzzle);
	}

	private void print(int[] puzzle){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < puzzle.length; i++){
			int row = getRow(i);
			int column = getColumn(i);
			
			String value = puzzle[i] == 0 ? " " : String.valueOf(puzzle[i]);
			sb.append(value);
			
			if(printNewLine(column)){
				sb.append("\n");
			}
			
			if(printHorzintalSeparator(row, column)){
				sb.append(getHorizontalSeparator());
			}
			
			if(printVerticalSeparator(column)){
				sb.append(getVerticalSeparator());
			}
		}
		
		System.out.println( sb.toString());
	}
	
	private boolean printVerticalSeparator(int column){
		if((column) % SEPARATOR_SIZE == 0 && column != SIDE_SIZE){
			return true;
		}
		
		return false;
	}
	
	private boolean printHorzintalSeparator(int row, int column){
		if((row) % SEPARATOR_SIZE == 0 && column == SIDE_SIZE && row != SIDE_SIZE){
			return true;
		}
		
		return false;
	}
	
	private boolean printNewLine(int column){
		if(column % SIDE_SIZE == 0){
			return true;
		}
		
		return false;
	}
	
	private int getRow(int puzzlePosition){
		return puzzlePosition / SIDE_SIZE + 1;
	}
	
	private int getColumn(int puzzlePosition){
		return puzzlePosition % SIDE_SIZE + 1;
	}
	
	private String getHorizontalSeparator(){
		return "---+---+---\n";
	}
	
	private String getVerticalSeparator(){
		return "|";
	}
}
