class Solution {
    public int[] findBall(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        for(int ball = 0; ball < grid[0].length; ball++) {
            int position = getColumn(ball, grid);
            list.add(position);
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    public static int getColumn(int inColumn, int[][] grid) {
        int i = 0;
        int j = inColumn;
        int n = grid.length;
        int m = grid[0].length;
        while(i < n) {
            if(j + 1 < m && grid[i][j] == 1 && grid[i][j + 1] == 1) {
                i++;
                j++;
            }
            else if(j - 1 >= 0 && grid[i][j] == -1 && grid[i][j - 1] == -1) {
                i++;
                j--;
            }
            else {
                return -1;
            }
        }
        return j;
    }
}
