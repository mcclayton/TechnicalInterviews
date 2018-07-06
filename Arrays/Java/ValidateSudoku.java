import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Given a 2d array representing a sudoku grid, determine if the
 * given Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are
 * filled with the character '.'.
 * A valid Sudoku board (partially filled) is not
 * necessarily solvable. Only the filled cells need to be validated.
 */

public class ValidateSudoku {

    public static void main(String[] args) {
        char[][] validSudokuBoard = {
            {'5','3','4','.','.','8','9','.','2'},
            {'6','7','2','1','9','5','3','4','8'},
            {'1','9','8','3','4','2','5','6','7'},
            {'8','5','9','7','6','1','4','2','3'},
            {'4','2','6','8','5','3','7','9','1'},
            {'7','1','3','.','2','.','8','5','6'},
            {'9','6','1','5','3','.','2','8','4'},
            {'2','8','7','4','1','9','6','3','.'},
            {'3','4','5','2','8','6','1','7','9'}
        };
        char[][] blankSudokuBoard = {
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
        };
        char[][] invalidSudokuBoard = {
            {'1','2','3','4','5','6','7','8','9'},
            {'.','.','.','.','.','.','6','5','4'},
            {'.','.','.','.','.','.','3','2','2'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
        };

        System.out.println(isValidSudoku(validSudokuBoard));    // True
        System.out.println(isValidSudoku(blankSudokuBoard));    // True
        System.out.println(isValidSudoku(invalidSudokuBoard));  // False
    }

    /**
     * Iterate over every row, every column, and then over every cube and ensure
     * all non-empty elements are unique.
     **/
    public static boolean isValidSudoku(char[][] board) {
       // Iterate over each row
       for (int i=0; i<9; i++) {
           HashSet<Character> seenInRow = new HashSet<Character>();
           HashSet<Character> seenInCol = new HashSet<Character>();

           // Iterate over each column
           for (int j=0; j<9; j++) {

               // If the space is not empty and we are adding a value seen before
               if (board[i][j] != '.' && !seenInRow.add(board[i][j])) {
                   return false;
               }

               // If the space is not empty and we are adding a value seen before
               if (board[j][i] != '.' && !seenInCol.add(board[j][i])) {
                   return false;
               }
           }
       }

       for (int i=0; i<9; i=i+3) {
           for (int j=0; j<9; j=j+3) {
               if (!isValidCube(board, i, j)) {
                   return false;
               }
           }
       }

       // At this point, every row, column, and cube is valid so return true
       return true;
   }

   // Given the starting row and starting column of a 3x3 cube, validate the numbers inside are unique
    public static boolean isValidCube(char[][] board, int startRow, int startCol) {
        HashSet<Character> seenInCube = new HashSet<Character>();

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                char valueInCube = board[startRow + i][startCol + j];
                // If the space is not empty and we are adding a value seen before
                if (valueInCube != '.' && !seenInCube.add(valueInCube)) {
                    return false;
                }
            }
        }
        return true;
    }
}
