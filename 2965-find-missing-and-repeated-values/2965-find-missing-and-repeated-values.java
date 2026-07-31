class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length * grid.length;

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int[] row : grid) {
            for (int num : row) {
                actualSum += num;
                actualSquareSum += (long) num * num;
            }
        }

        long diff = actualSum - expectedSum;                     // x - y
        long squareDiff = actualSquareSum - expectedSquareSum;   // x² - y²

        long sumXY = squareDiff / diff;                          // x + y

        long repeated = (diff + sumXY) / 2;
        long missing = repeated - diff;

        return new int[]{(int) repeated, (int) missing};
    }
}