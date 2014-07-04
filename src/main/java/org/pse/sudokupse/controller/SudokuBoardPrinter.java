package org.pse.sudokupse.controller;

import org.pse.sudokupse.model.Board;
import org.pse.sudokupse.model.BoardPrinter;
import org.pse.sudokupse.model.SudokuBoard;

public class SudokuBoardPrinter implements BoardPrinter{

	
	
	public void print(Board board) {
		int[] puzzle = board.getPuzzle();
		if(puzzle.length != SudokuBoard.MAJOR_SQUARE_SIZE * SudokuBoard.MAJOR_SQUARE_SIZE){
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
		if((column) % SudokuBoard.MINOR_SQUARE_SIZE == 0 && column != SudokuBoard.MAJOR_SQUARE_SIZE){
			return true;
		}
		
		return false;
	}
	
	private boolean printHorzintalSeparator(int row, int column){
		if((row) % SudokuBoard.MINOR_SQUARE_SIZE == 0 && column == SudokuBoard.MAJOR_SQUARE_SIZE && row != SudokuBoard.MAJOR_SQUARE_SIZE){
			return true;
		}
		
		return false;
	}
	
	private boolean printNewLine(int column){
		if(column % SudokuBoard.MAJOR_SQUARE_SIZE == 0){
			return true;
		}
		
		return false;
	}
	
	private int getRow(int puzzlePosition){
		return puzzlePosition / SudokuBoard.MAJOR_SQUARE_SIZE + 1;
	}
	
	private int getColumn(int puzzlePosition){
		return puzzlePosition % SudokuBoard.MAJOR_SQUARE_SIZE + 1;
	}
	
	private String getHorizontalSeparator(){
		return "---+---+---\n";
	}
	
	private String getVerticalSeparator(){
		return "|";
	}
}
