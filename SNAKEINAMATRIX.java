class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int element = 0;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = element;
                element++;
            }
        }
        int x = 0; 
        int y = 0; 
        for (String com : commands) {
            if (com.equals("RIGHT")) {
                x++;
            } else if (com.equals("LEFT")) {
                x--;
            } else if (com.equals("UP")) {
                y--;
            } else if (com.equals("DOWN")) {
                y++;
            }
        }

        return arr[y][x];
    }
}
