class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] checkRows = new int[n];
        int[] checkCols = new int[m];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int element = mat[i][j];
                ArrayList<Integer> indexes = new ArrayList<>();
                indexes.add(i); 
                indexes.add(j); 
                map.put(element, indexes);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            ArrayList<Integer> indexes = map.get(element);
            int row = indexes.get(0);
            int col = indexes.get(1);
            checkRows[row]++;
            checkCols[col]++;
            if (checkRows[row] == m || checkCols[col] == n) {
                return i;
            }
            map.remove(element);
        }
        return -1;
    }
}
