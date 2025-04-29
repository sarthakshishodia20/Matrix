class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int steps=0;
            int row=startPos[0];
            int col=startPos[1];
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)=='U'){
                    row--;
                }
                else if(s.charAt(j)=='D'){
                    row++;
                }
                else if(s.charAt(j)=='L'){
                    col--;
                }
                else if(s.charAt(j)=='R'){
                    col++;
                }
                if(row>=0 && row<n && col>=0 && col<n ){
                    steps++;
                }
                else{
                    break;
                }
            }
            ans[i]=steps;
        }
        return ans;
    }
}
