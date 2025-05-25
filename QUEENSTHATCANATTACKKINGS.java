class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        char[][] chessboard = new char[8][8];
        for (int[] queenPos : queens) {
            int x = queenPos[0];
            int y = queenPos[1];
            chessboard[x][y] = '♛';
        }
        chessboard[king[0]][king[1]] = '♔';
        int i, j;
        i = king[0] - 1;
        j = king[1];
        while (i >= 0) {
            if (chessboard[i][j] == '♛') {
                chessboard[i][j] = 'Q';
                break;
            }
            i--;
        }
        i = king[0] - 1;
        j = king[1] + 1;
        while (i >= 0 && j < 8) {
            if (chessboard[i][j] == '♛') {
                chessboard[i][j] = 'Q';
                break;
            }
            i--;
            j++;
        }
        i = king[0];
        j = king[1] + 1;
        while (j < 8) {
            if (chessboard[i][j] == '♛') {
                chessboard[i][j] = 'Q';
                break;
            }
            j++;
        }
        i = king[0] + 1;
        j = king[1] + 1;
        while (i < 8 && j < 8) {
            if (chessboard[i][j] == '♛') {
                chessboard[i][j] = 'Q';
                break;
            }
            i++;
            j++;
        }
        i = king[0] + 1;
        j = king[1];
        while (i < 8) {
            if (chessboard[i][j] == '♛') {
                chessboard[i][j] = 'Q';
                break;
            }
            i++;
        }
        i = king[0] + 1;
        j = king[1] - 1;
        while (i < 8 && j >= 0) {
            if (chessboard[i][j] == '♛') {
                chessboard[i][j] = 'Q';
                break;
            }
            i++;
            j--;
        }
        i = king[0];
        j = king[1] - 1;
        while (j >= 0) {
            if (chessboard[i][j] == '♛') {
                chessboard[i][j] = 'Q';
                break;
            }
            j--;
        }
        i = king[0] - 1;
        j = king[1] - 1;
        while (i >= 0 && j >= 0) {
            if (chessboard[i][j] == '♛') {
                chessboard[i][j] = 'Q';
                break;
            }
            i--;
            j--;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (chessboard[r][c] == 'Q') {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(r);
                    pos.add(c);
                    result.add(pos);
                }
            }
        }
        return result;
    }
}
