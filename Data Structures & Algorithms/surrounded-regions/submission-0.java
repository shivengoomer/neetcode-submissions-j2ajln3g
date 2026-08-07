class Solution {

    void check(int i, int j, char[][] board) {

        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] != 'O') {
            return;
        }

        // Mark this O as safe
        board[i][j] = '#';

        // 4 directions only
        check(i + 1, j, board);
        check(i - 1, j, board);
        check(i, j + 1, board);
        check(i, j - 1, board);
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // Check first and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                check(i, 0, board);

            if (board[i][m - 1] == 'O')
                check(i, m - 1, board);
        }

        // Check first and last row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                check(0, j, board);

            if (board[n - 1][j] == 'O')
                check(n - 1, j, board);
        }

        // Capture surrounded regions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
}