class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int[][] prefixZor=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int top=i>0?prefixZor[i-1][j]:0;
                int left=j>0?prefixZor[i][j-1]:0;
                int topLeft=i>0 && j>0? prefixZor[i-1][j-1]:0;
                prefixZor[i][j]=(((matrix[i][j]^top)^left)^topLeft);
                pq.add(prefixZor[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}
