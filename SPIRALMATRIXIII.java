class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int result[][]=new int[rows*cols][2];
        int steps=1;
        int index=0;
        int r=rStart;
        int c=cStart;
        result[index++]=new int[]{r,c};
        while(index<rows*cols){
            // rightMove Kro
            for(int i=0;i<steps;i++){
                c++;
                if(c>=0 && c<cols && r>=0 && r<rows){
                    result[index++]=new int[]{r,c};
                }
            }
            // down Move Kro
            for(int i=0;i<steps;i++){
                r++;
                if(c>=0 && c<cols && r>=0 && r<rows){
                    result[index++]=new int[]{r,c};
                }
            }
            steps++;
            // left Move Kro
            for(int i=0;i<steps;i++){
                c--;
                if(c>=0 && c<cols && r>=0 && r<rows){
                    result[index++]=new int[]{r,c};
                }
            }
            // Up Move Kro
            for(int i=0;i<steps;i++){
                r--;
                if(r>=0 && r<rows && c>=0 && c<cols){
                    result[index++]=new int[]{r,c};
                }
            }
            steps++;
        }
        return result;

    }
}
