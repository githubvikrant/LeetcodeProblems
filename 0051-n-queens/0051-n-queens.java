import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Fill the board with empty squares '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        placeQueens(0, board, result);
        return result;
    }

    private void placeQueens(int row, char[][] board, List<List<String>> result) {
        // Base Case: If we successfully placed queens in all rows, save the board
        if (row == board.length) {
            result.add(convertBoardToList(board));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';          // 1. Make choice
                
                placeQueens(row + 1, board, result); // 2. Explore next row
                
                board[row][col] = '.';          // 3. Undo choice (Backtrack)
            }
        }
    }

    // A simple, visual check to see if a queen can be safely placed
    private boolean isValid(char[][] board, int row, int col) {
        // 1. Check straight up (same column)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // 2. Check diagonally up-left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // 3. Check diagonally up-right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true; // Safe to place!
    }

    // Helper method to convert char[][] board into LeetCode's format
    private List<String> convertBoardToList(char[][] board) {
        List<String> formattedBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            formattedBoard.add(new String(board[i]));
        }
        return formattedBoard;
    }
}
