class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '1';
            }
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
        }
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == 'W' || grid[i][y] == 'G') break;
                if (grid[i][y] == '1') grid[i][y] = 'X';
            }
            for (int i = x + 1; i < m; i++) {
                if (grid[i][y] == 'W' || grid[i][y] == 'G') break;
                if (grid[i][y] == '1') grid[i][y] = 'X';
            }
            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == 'W' || grid[x][j] == 'G') break;
                if (grid[x][j] == '1') grid[x][j] = 'X';
            }
            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == 'W' || grid[x][j] == 'G') break;
                if (grid[x][j] == '1') grid[x][j] = 'X';
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') count++;
            }
        }
        return count;
    }
}
