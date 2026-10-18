class Solution {
    int[][] dp;
    int dfs(int i, int j, int m, int n) {
        if (i < 0 || j < 0)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (dp[i][j] != 0)
            return dp[i][j];
        return dp[i][j] = dfs(i - 1, j, m, n) + dfs(i, j - 1, m, n);
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return dfs(m - 1, n - 1, m, n);
    }
}