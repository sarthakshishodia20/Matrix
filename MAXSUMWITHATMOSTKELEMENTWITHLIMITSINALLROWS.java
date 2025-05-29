class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]); 
            int count = 0; 
            for (int j = grid[i].length - 1; j >= 0 && count < limits[i]; j--) {
                pq.add(grid[i][j]);
                count++;
                if (pq.size() > k) {
                    pq.poll(); 
                }
            }
        }
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
