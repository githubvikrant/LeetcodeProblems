class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    String st = dfs(i, j, word, 0, board);
                    if (word.equals(st)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    String dfs(int i, int j, String word, int k, char[][] board) {
        // SUCCESS BASE CASE: Put this BEFORE boundary checks.
        // If k reaches the end, it means the *previous* steps matched everything.
        if (k == word.length()) {
            return ""; 
        }

        // FAILURE BASE CASE: Out of bounds or mismatch
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return null; // Return null to indicate this path failed completely
        }

        char temp = board[i][j];
        board[i][j] = '#'; // Mark visited

        // Explore all 4 directions independently
        String up = dfs(i - 1, j, word, k + 1, board);
        String down = dfs(i + 1, j, word, k + 1, board);
        String left = dfs(i, j - 1, word, k + 1, board);
        String right = dfs(i, j + 1, word, k + 1, board);

        board[i][j] = temp; // Backtrack

        // Check if ANY single path successfully processed the rest of the string
        // The rest of the string is successful if the returned string is NOT null.
        if (up != null) return temp + up;
        if (down != null) return temp + down;
        if (left != null) return temp + left;
        if (right != null) return temp + right;

        // If all 4 directions returned null, this path is a dead end
        return null; 
    }
}
