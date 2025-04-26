class Solution {
    public int numRookCaptures(char[][] board) {
        int n=board.length;;
        int m=board[0].length;
        int countPawns=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='R'){
                    int x=i;
                    int y=j;
                    for(int k=x-1;k>=0;k--){
                        if(board[k][y]=='B'){
                            break;
                        }
                        if(board[k][y]=='p'){
                            countPawns++;
                            break;
                        }

                    }
                    for(int k=x+1;k<n;k++){
                        if(board[k][y]=='B'){
                            break;
                        }
                        if(board[k][y]=='p'){
                            countPawns++;
                            break;
                        }
                    }
                    for(int k=y-1;k>=0;k--){
                        if(board[x][k]=='B'){
                            break;
                        }
                        if(board[x][k]=='p'){
                            countPawns++;
                            break;
                        }

                    }
                    for(int k=y+1;k<m;k++){
                        if(board[x][k]=='B'){
                            break;
                        }
                        if(board[x][k]=='p'){
                            countPawns++;
                            break;
                        }
                    }
                }
            }
        }
        return countPawns;
    }
}
