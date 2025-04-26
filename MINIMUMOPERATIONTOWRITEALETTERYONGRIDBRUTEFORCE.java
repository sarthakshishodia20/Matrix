class Solution {    
    static class Pair {
        int key, freq;
        Pair(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }
    
    public int minimumOperationsToWriteY(int[][] grid) {
        HashMap<Integer, Integer> why = new HashMap<>();
        HashMap<Integer, Integer> other = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int i = 0, j = 0;
        while (i < n/2 && j < m/2) {
            int element = grid[i][j];
            visited[i][j] = 1;
            why.put(element, why.getOrDefault(element, 0) + 1);
            i++;
            j++;
        }
        
        i = 0;
        j = m - 1;
        while (i < n/2 && j > m/2) {
            int element = grid[i][j];
            visited[i][j] = 1;
            why.put(element, why.getOrDefault(element, 0) + 1);
            i++;
            j--;
        }
        i = n/2;
        j = m/2;
        while (i < n) {
            int element = grid[i][j];
            visited[i][j] = 1;
            why.put(element, why.getOrDefault(element, 0) + 1);
            i++;
        }
        
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    int element = grid[i][j];
                    other.put(element, other.getOrDefault(element, 0) + 1);
                }
            }
        }
        PriorityQueue<Pair> pqWhy = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        PriorityQueue<Pair> pqOther = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Map.Entry<Integer, Integer> entry : why.entrySet()) {
            pqWhy.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<Integer, Integer> entry : other.entrySet()) {
            pqOther.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int totalY = 0, totalOther = 0;
        for (int v : why.values()) totalY += v;
        for (int v : other.values()) totalOther += v;
        Pair top1Why = pqWhy.isEmpty() ? new Pair(-1, 0) : pqWhy.poll();
        Pair top2Why = pqWhy.isEmpty() ? new Pair(-1, 0) : pqWhy.poll();
        Pair top1Other = pqOther.isEmpty() ? new Pair(-1, 0) : pqOther.poll();
        Pair top2Other = pqOther.isEmpty() ? new Pair(-1, 0) : pqOther.poll();
        int res = Integer.MAX_VALUE;
        if (top1Why.key != top1Other.key) {
            res = (totalY - top1Why.freq) + (totalOther - top1Other.freq);
        } else {
            int option1 = (totalY - top1Why.freq) + (totalOther - top2Other.freq);
            int option2 = (totalY - top2Why.freq) + (totalOther - top1Other.freq);
            res = Math.min(option1, option2);
        }
        return res;
    }
}
