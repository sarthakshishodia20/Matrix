class Solution {
    public int maxMoves(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < grid.length; i++) {
            ans = Math.max(ans, dfs(grid, dp, i, 0));
        }
        return ans;
    }

    public int dfs(int[][] grid, int[][] dp, int row, int col) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int[] dirs = {-1, 0, 1};
        int maxMoves = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int k = 0; k < 3; k++) {
            int nrow = row + dirs[k];
            int ncol = col + 1;
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[row][col] < grid[nrow][ncol]) {
                maxMoves = Math.max(maxMoves, 1 + dfs(grid, dp, nrow, ncol));
            }
        }
        dp[row][col] = maxMoves;
        return dp[row][col];
    }
}
