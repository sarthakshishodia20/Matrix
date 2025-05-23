class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int cStart = booking[0] - 1;
            int cEnd = booking[1] - 1;
            int seats = booking[2];
            for (int j = cStart; j <= cEnd; j++) {
                ans[j] += seats;
            }
        }
        return ans;
    }
}
