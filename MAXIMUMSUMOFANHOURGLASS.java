class Solution {
    public int maxSum(int[][] grid) {
        int maxSum = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                int top = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1];
                int mid = grid[i][j];
                int bottom = grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
                int hourglassSum = top + mid + bottom;
                maxSum = Math.max(maxSum, hourglassSum);
            }
        }
        return maxSum;
    }
}
