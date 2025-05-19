class Solution {
    // if to rotate an array by right use => (0,n-1)
    // (0,k-1);
    // (k,n-1);
    // for left rotation use k=n-(k%n); to convert the rotation direction 
    public int[][] rotateGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int layers = Math.min(rows, cols) / 2;
        for (int i = 0; i < layers; i++) {
            int startRow = i, startCol = i;
            int endRow = rows - 1 - i, endCol = cols - 1 - i;
            List<Integer> layer = new ArrayList<>();
            int r = startRow, c = startCol;
            while (c <= endCol) layer.add(grid[r][c++]);
            c = endCol; r = startRow + 1;
            while (r <= endRow) layer.add(grid[r++][c]);
            r = endRow; c = endCol - 1;
            while (c >= startCol) layer.add(grid[r][c--]);
            c = startCol; r = endRow - 1;
            while (r > startRow) layer.add(grid[r--][c]);
            int n = layer.size();
            int rotation = k % n;
            rotation = n - rotation; 
            reverse(layer, 0, n - 1);
            reverse(layer, 0, rotation - 1);
            reverse(layer, rotation, n - 1);
            int index = 0;
            r = startRow; c = startCol;
            while (c <= endCol) grid[r][c++] = layer.get(index++);
            c = endCol; r = startRow + 1;
            while (r <= endRow) grid[r++][c] = layer.get(index++);
            r = endRow; c = endCol - 1;
            while (c >= startCol) grid[r][c--] = layer.get(index++);
            c = startCol; r = endRow - 1;
            while (r > startRow) grid[r--][c] = layer.get(index++);
        }
        return grid;
    }
    private void reverse(List<Integer> list, int l, int r) {
        while (l < r) {
            int temp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, temp);
            l++;
            r--;
        }
    }
}
