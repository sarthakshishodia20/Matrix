class Solution {
    static class Pair implements Comparable<Pair> {
        int element;
        int frequency;
        public Pair(int element, int freq) {
            this.element = element;
            this.frequency = freq;
        }
        @Override
        public int compareTo(Pair p2) {
            return p2.frequency - this.frequency;
        }
    }
    public int minimumOperationsToWriteY(int[][] grid) {
        HashMap<Integer, Integer> mapY = new HashMap<>();
        HashMap<Integer, Integer> mapOther = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        while (i < n / 2 && j < m / 2) {
            int element = grid[i][j];
            visited[i][j] = 1;
            mapY.put(element, mapY.getOrDefault(element, 0) + 1);
            i++;
            j++;
        }
        i = 0;
        j = m - 1;
        while (i < n / 2 && j > m / 2) {
            int element = grid[i][j];
            visited[i][j] = 1;
            mapY.put(element, mapY.getOrDefault(element, 0) + 1);
            i++;
            j--;
        }
        i = n / 2;
        j = m / 2;
        while (i < n) {
            int element = grid[i][j];
            visited[i][j] = 1;
            mapY.put(element, mapY.getOrDefault(element, 0) + 1);
            i++;
        }
        for (int I = 0; I < n; I++) {
            for (int J = 0; J < m; J++) {
                if (visited[I][J] == 0) {
                    mapOther.put(grid[I][J], mapOther.getOrDefault(grid[I][J], 0) + 1);
                }
            }
        }
        PriorityQueue<Pair> pqY = new PriorityQueue<>();
        PriorityQueue<Pair> pqO = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : mapY.entrySet()) {
            pqY.add(new Pair(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<Integer, Integer> entry : mapOther.entrySet()) {
            pqO.add(new Pair(entry.getKey(), entry.getValue()));
        }
        int totalY = 0;
        int totalO = 0;
        for (int ele : mapY.values()) {
            totalY += ele;
        }
        for (int ele : mapOther.values()) {
            totalO += ele;
        }
        int res = 0;
        Pair y1 = pqY.poll();
        Pair y2 = pqY.poll();
        Pair o1 = pqO.poll();
        Pair o2 = pqO.poll();
        int topFirstYElement = y1 != null ? y1.element : -1;
        int topFirstYFrequency = y1 != null ? y1.frequency : 0;
        int topSecondYFrequency = y2 != null ? y2.frequency : 0;
        int topFirstOElement = o1 != null ? o1.element : -1;
        int topFirstOFrequency = o1 != null ? o1.frequency : 0;
        int topSecondOFrequency = o2 != null ? o2.frequency : 0;
        if (topFirstYElement != topFirstOElement) {
            res = (totalY - topFirstYFrequency) + (totalO - topFirstOFrequency);
        } else {
            int ans1 = (totalY - topFirstYFrequency) + (totalO - topSecondOFrequency);
            int ans2 = (totalY - topSecondYFrequency) + (totalO - topFirstOFrequency);
            res = Math.min(ans1, ans2);
        }
        return res;
    }
}
