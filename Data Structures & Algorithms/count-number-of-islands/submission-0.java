class Solution {

    public void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return;
        if (visited[r][c] || grid[r][c] == '0')
            return;
        visited[r][c] = true;
        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r - 1, c);
        dfs(grid, visited, r, c + 1);
        dfs(grid, visited, r, c - 1);
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ct = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    ct++;
                }
            }
        }

        return ct;
    }
}