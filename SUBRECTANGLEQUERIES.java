class SubrectangleQueries {
    int[][] rectangle;
    public SubrectangleQueries(int[][] rectangl) {
        rectangle = new int[rectangl.length][rectangl[0].length];
        for (int i = 0; i < rectangl.length; i++) {
            for (int j = 0; j < rectangl[0].length; j++) {
                rectangle[i][j] = rectangl[i][j];
            }
        }
    }
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                rectangle[r][c] = newValue;
            }
        }
    }
    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
