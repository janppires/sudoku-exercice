package org.pse.sudokupse;

import org.pse.sudokupse.controller.SudokuBoardPrinter;
import org.pse.sudokupse.model.Board;
import org.pse.sudokupse.model.SudokuBoard;

/**
 * Hello world!
 *
 */
public class PlaySudoku 
{
    public static void main( String[] args ){
    	int[] puzzle = new int [] { 
    			 0,0,2,5,0,0,0,0,3, 
    			 0,4,0,0,6,7,0,0,0, 
    			 1,5,0,0,0,3,0,0,0, 
    			 0,0,8,0,0,0,0,0,4, 
    			 5,6,0,0,0,0,0,1,7, 
    			 4,0,0,0,0,0,8,0,0, 
    			 0,0,0,6,0,0,0,8,1, 
    			 0,0,0,1,8,0,0,2,0, 
    			 2,0,0,0,0,5,7,0,0 };
    	
        Board board = new SudokuBoard(puzzle, new SudokuBoardPrinter());
        board.print();
        
        System.out.println(board.validate(80, 8));
    }
}
