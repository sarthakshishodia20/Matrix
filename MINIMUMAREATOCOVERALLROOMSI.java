class Solution {
    public int minimumArea(int[][] grid) {
        int firstRow=Integer.MAX_VALUE;
        int lastRow=-1;
        int firstCol=Integer.MAX_VALUE;
        int lastCol=-1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    firstRow=Math.min(firstRow,i);
                    lastRow=Math.max(lastRow,i);
                    firstCol=Math.min(firstCol,j);
                    lastCol=Math.max(lastCol,j);
                }
            }
        }
        if(lastRow==-1){
            return -1;
        }
        int height=lastRow-firstRow+1;
        int width=lastCol-firstCol+1;
        return height*width;
    }
}
