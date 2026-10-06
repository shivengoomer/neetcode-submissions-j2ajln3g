class Solution {
    boolean search(char[][] board, String word, boolean[][] visited,
                   int i, int j, int idx) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || visited[i][j]
            || board[i][j] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean found =
            search(board, word, visited, i - 1, j, idx + 1) ||
            search(board, word, visited, i + 1, j, idx + 1) ||
            search(board, word, visited, i, j + 1, idx + 1) ||
            search(board, word, visited, i, j - 1, idx + 1);
        visited[i][j] = false;
        return found;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}