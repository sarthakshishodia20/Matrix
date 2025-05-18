class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int distinctInAboveLeft = 0;
                int distinctInBelowRight = 0;
                int I = i-1;
                int J = j-1;
                HashMap<Integer, Integer> mapL = new HashMap<>();
                while (I >= 0 && J >= 0) {
                    mapL.put(grid[I][J], mapL.getOrDefault(grid[I][J], 0) + 1);
                    I--;
                    J--;
                }
                distinctInAboveLeft = mapL.size();
                I = i+1;
                J = j+1;
                HashMap<Integer, Integer> mapR = new HashMap<>();
                while (I < n && J < m) {
                    mapR.put(grid[I][J], mapR.getOrDefault(grid[I][J], 0) + 1);
                    I++;
                    J++;
                }
                distinctInBelowRight = mapR.size();
                ans[i][j] = Math.abs(distinctInAboveLeft - distinctInBelowRight);
            }
        }
        return ans;
    }
}
