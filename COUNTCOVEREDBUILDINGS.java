class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[][] grid = new int[n][n];
        for (int[] building : buildings) {
            int x = building[0] - 1; 
            int y = building[1] - 1; 
            grid[x][y]=1;
        }

        int count = 0;
        for (int[] building : buildings) {
            int x = building[0] - 1;
            int y = building[1] - 1;
            if (isCovered(x, y, grid)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isCovered(int x, int y, int[][] grid) {
        boolean up = false;
        for (int i = x - 1; i >= 0; i--) { 
            if (grid[i][y] == 1) {
                up = true;
                break;
            }
        }
        boolean down = false;
        for (int i = x + 1; i < grid.length; i++) {
            if (grid[i][y] == 1) {
                down = true;
                break;
            }
        }
        boolean left = false;
        for (int i = y - 1; i >= 0; i--) { 
            if (grid[x][i] == 1) {
                left = true;
                break;
            }
        }
        boolean right = false;
        for (int i = y + 1; i < grid[0].length; i++) {
            if (grid[x][i] == 1) {
                right = true;
                break;
            }
        }
        return up && down && left && right;
    }
}
