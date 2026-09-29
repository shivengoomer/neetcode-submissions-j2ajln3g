class Solution {
    boolean makeIsland(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || 
            j < 0 || j >= grid[0].length ||
            visited[i][j] || grid[i][j] == '0') {
            return false;
        }
        visited[i][j] = true;
        makeIsland(grid, visited, i + 1, j);
        makeIsland(grid, visited, i - 1, j);
        makeIsland(grid, visited, i, j + 1);
        makeIsland(grid, visited, i, j - 1);
        return true;
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    if (makeIsland(grid, visited, i, j)) {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}