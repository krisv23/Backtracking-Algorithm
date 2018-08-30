/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;



class ReapandSow {

    public static int rows, cols;
    public static int[][] board;
    public static int boardSize;
    public static int IMPOSSIBLE = 0;

    public static void main(String[] fury) {
        Scanner sc = new Scanner(System.in);

        rows = sc.nextInt();
        cols = sc.nextInt();

        boardSize = rows * cols;
        board = new int[rows][cols];

        for(int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++){
                board[i][j] = sc.nextInt();
            }
        
        if(solve(0,0))
        	printBoard();
        else
        	System.out.print("IMPOSSIBLE!");

            
    }
        
        public static boolean solve(int row, int col) {
        	
        	printBoard();
        	 
        	//if valid check proves false return back
        	if(!valid())
        		 return false;
        	//If end of board, end sequence
        	if(row == rows)
        		 return false;
        	//if end of the column, increment to next row and continue
        	if(col == cols)
        		 return solve(row + 1, 0);
        	
        	//
        	//for(int i = 0; i < cols; i++) {

        			//If plot is not plotable or already taken
        			if (board[row][col] == 0 || board[row][col] == 1)
        				solve(row, col + 1);
        			
        			//Plant crops
        			board[row][col] = 1;
        			
        			//Check next placement
        			if(solve(row, col + 1))
        				return true;
        			
        			//Otherwise Backtrack and set no crops
        			board[row][col] = 0;   
//        			if(solve(row, col + 1))
//        				return true;
       // }
        	
        	return false;
        	  
        }
        
        public static boolean valid() {
        	int count = 0;
        	
        	//valid check to see if there is 3 in a row 
        	for(int i = 0; i < rows; i++) 
        		for(int j = 0; j < cols; j++) {
        			
        			//if a 1 is found increment count by 1
        			if (board[i][j] == 1 )
        				count++;
        			//if anything other than 1 is found set to 0
        			else 
        				count = 0;
        			
        			//if count reach's 3 set to 0
        			if(count == 3)
        				return false;
        			//if end of row or end of column, set count to 0
        			if(i == rows - 1 || j == cols - 1)
        				count = 0;

        		}
        	
        	//check if 3 in a col
        	for (int i = 0; i < cols; i ++) {
        		for (int j = 0; j < rows; j ++) {
        			if(board[j][i] == 1)
        				count++;
        			else
        				count = 0;
        			
        			if (count == 3)
        				return false;
        			
        			if(i == rows - 1 || j == cols - 1)
        				count = 0;
        		}
        	
        	}
        	return true;
        }
        
        public static void printBoard() {
          for(int i = 0; i < rows; i++) {
        	  for (int j = 0; j < cols; j++)
        		  System.out.print(board[i][j] + " ");
        	  
          
          System.out.println("\n");

          }
          System.out.println("\n\n\n");
        }
}
    

