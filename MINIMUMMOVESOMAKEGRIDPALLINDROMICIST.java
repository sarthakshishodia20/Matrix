class Solution {
    public int minFlips(int[][] grid) {
        int countRowFlip = 0;
        for (int[] row : grid) {
            countRowFlip += getRow(row.clone());
        }
        int countColFlip = 0;
        for (int j = 0; j < grid[0].length; j++) {
            List<Integer> lis = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                lis.add(grid[i][j]); 
            }
            countColFlip += getCol(lis);
        }
        return Math.min(countRowFlip, countColFlip);
    }
    public static int getRow(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int count = 0; 
        while (l < r) {
            if (arr[l] == arr[r]) {
                l++;
                r--;
            } else {
                if (arr[l] == 0) {
                    arr[l] = 1;
                    count++;
                }
                if (arr[r] == 0) {
                    arr[r] = 1;
                    count++;
                }
                l++;
                r--;
            }
        }
        return count;
    }

    public static int getCol(List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        int count = 0;
        while (l < r) {
            if (list.get(l).equals(list.get(r))) {
                l++;
                r--;
            } else {
                if (list.get(l) == 0) {
                    list.set(l, 1);
                    count++;
                }
                if (list.get(r) == 0) {
                    list.set(r, 1);
                    count++;
                }
                l++;
                r--;
            }
        }
        return count;
    }
}
