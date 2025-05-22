class Solution {
    // Same as Leetcode 1253 keep the smallest so that both value come in rowSum and ColSum
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans=new int[rowSum.length][colSum.length];
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                ans[i][j]=Math.min(rowSum[i],colSum[j]);
                rowSum[i]=rowSum[i]-ans[i][j];
                colSum[j]=colSum[j]-ans[i][j];
            }
        }
        for(int ele:rowSum){
            if(ele!=0){
                int[][] Ans=new int[ans.length][ans[0].length];
                return Ans;
            }
        }
        for(int ele:colSum){
            if(ele!=0){
                int[][] Ans=new int[ans.length][ans[0].length];
                return Ans;
            }
        }
        return ans;
    }
}
