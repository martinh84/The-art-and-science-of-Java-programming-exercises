import acm.program.*;
import java.util.*;

/**
 * Question from The art and science of Java An Introduction to  Computer Science. Eric S. Roberts
 * Chapter 11. Exercise 4.
 * Implement a method isMagicSquare that tests to see whether an 3x3 array contains a magic square. A Magic Square
 * is where each row, col and diagonal equate to the same number.  This number is determined in the constant MAGIC_NUMBER.
 * 
 * I will come back at a later date to improve the display method, showing the user a matrix, instead of a println.
 * 
 * @author marti
 */

public class Main extends ConsoleProgram {
				
	public void run() {
		setFont("helvetica-36");
		int[][] square = new int[3][3];
		for(int i = 0; i < ROWS; i++) {
			square[0][i] = readInt("Please enter a number for the top row: ");
		} for(int i = 0; i < ROWS; i++) {
			square[1][i] = readInt("Please enter a number for the middle row: ");
		} for(int i = 0; i < ROWS; i++) {
			square[2][i] = readInt("Please enter a number for the bottom row: ");
		} 
		
		displayNumbers(square);
		boolean result = isMagicSquare(square);
		println("\nIs the square MAGIC? " + result);
		}
	
	/*Displays the numbers back to the user so they can see their choices*/
	private void displayNumbers(int[][] array) {
		for(int i = 0; i < ROWS ; i++) {
			for(int j = 0; j < COLS; j++) {
				print(array[i][j] + " ");
			}
		}
	}
	
	/*Creates variables that are the sums of the rows, columns and diagonals in the matrix, then send to check if they match the MAGIC_NUMBER */
	private boolean isMagicSquare(int[][] array) {
		/* for the rows*/
		int row1 = (array[0][0] + array[0][1] +array[0][2]);
		int row2 = (array[1][0] + array[1][1] +array[1][2]);
		int row3 = (array[2][0] + array[2][1] +array[2][2]);
		/* for the columns*/
		int col1 = (array[0][0] + array[1][0] +array[2][0]);
		int col2 = (array[0][1] + array[1][1] +array[2][1]);
		int col3 = (array[0][2] + array[1][2] +array[2][2]);
		/* for the diagonals*/
		int diagonal1 = (array[0][0] + array[1][1] +array[2][2]);
		int diagonal2 = (array[0][2] + array[1][1] +array[2][0]);
		
		return checkTheNumbers(row1, row2, row3, col1, col2, col3, diagonal1, diagonal2);
	}
	
	/*Method to check is the numbers in each row, column and diagonal all add up to 15. returns true is they do, false if they don't*/
	private boolean checkTheNumbers(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8) {
		boolean answer = false;
		if(num1 == MAGIC_NUMBER && num2 == MAGIC_NUMBER && num3 == MAGIC_NUMBER && num4 == MAGIC_NUMBER && 
				num5 == MAGIC_NUMBER && num6 == MAGIC_NUMBER && num7 == MAGIC_NUMBER && num8 ==MAGIC_NUMBER) {
			answer = true;
			} else {
				answer = false;
			} return answer;
	}
	
	/* private constants */
	private static final int MAGIC_NUMBER = 15;
	private static final int ROWS = 3;
	private static final int COLS = 3;
}
