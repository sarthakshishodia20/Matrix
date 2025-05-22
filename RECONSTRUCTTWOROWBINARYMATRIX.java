class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[] upperRow = new int[n];
        int[] lowerRow = new int[n];
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                upperRow[i] = 1;
                lowerRow[i] = 1;
                upper--;
                lower--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    upperRow[i] = 1;
                    upper--;
                } else if (lower > 0) {
                    lowerRow[i] = 1;
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            }
        }
        if (upper != 0 || lower != 0) return new ArrayList<>(); 
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(toList(upperRow));
        ans.add(toList(lowerRow));
        return ans;
    }
    private List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}
