class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[index++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int medianValue = arr[size / 2]; 
        int minOperation = 0;
        for (int i = 0; i < size; i++) {
            int diff = Math.abs(arr[i] - medianValue);
            if (diff % x != 0) return -1;
            minOperation += diff / x;
            // kitni values ek baari mein le skte hai vhi hai 
        }
        return minOperation;
    }
}
