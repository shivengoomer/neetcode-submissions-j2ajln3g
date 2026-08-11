class Solution {

    boolean find(char[][] board, boolean[][] visited, String word,
                 int i, int j, int pos) {

        // Entire word matched
        if (pos == word.length())
            return true;

        // Out of bounds / already visited
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            visited[i][j])
            return false;

        // Current character doesn't match
        if (board[i][j] != word.charAt(pos))
            return false;

        // Mark current cell
        visited[i][j] = true;

        // Explore all 4 directions
        boolean found =
            find(board, visited, word, i + 1, j, pos + 1) ||
            find(board, visited, word, i - 1, j, pos + 1) ||
            find(board, visited, word, i, j + 1, pos + 1) ||
            find(board, visited, word, i, j - 1, pos + 1);

        // Backtrack
        visited[i][j] = false;

        return found;
    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visited =
            new boolean[board.length][board[0].length];

        // Start from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (find(board, visited, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }
}