class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] dummy = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dummy[i][j] = boxGrid[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(dummy[i]);
        }
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (dummy[i][j] == '.') {
                    int nextRowWithStone = -1;
                    for (int k = i - 1; k >= 0; k--) {
                        if (dummy[k][j] == '*') {
                            break;
                        }
                        if (dummy[k][j] == '#') {
                            nextRowWithStone = k;
                            break;
                        }
                    }
                    if (nextRowWithStone != -1) {
                        dummy[nextRowWithStone][j] = '.';
                        dummy[i][j] = '#';
                    }
                }
            }
        }
        return dummy;
    }
    public static void reverse(char[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
