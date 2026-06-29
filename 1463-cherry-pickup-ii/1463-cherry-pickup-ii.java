class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        
        for (int[][] row2D : dp) {
            for (int[] row1D : row2D) {
                Arrays.fill(row1D, -1);
            }
        }
        
        return helper(0, 0, cols - 1, grid, rows, cols, dp);
    }

    private int helper(int i, int j1, int j2, int[][] grid, int rows, int cols, int[][][] dp) {
        if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols) {
            return (int) -1e9;
        }
        if (i == rows - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        
        int maxCherries = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }
                value += helper(i + 1, j1 + dj1, j2 + dj2, grid, rows, cols, dp);
                maxCherries = Math.max(maxCherries, value);
            }
        }
        return dp[i][j1][j2] = maxCherries;
    }
}