class Solution {

    Integer[][] dp;

    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        dp = new Integer[n][n];

        return helper(piles, 0, n - 1) > 0;
    }

    private int helper(int[] piles, int i, int j) {

        if (i == j)
            return piles[i];

        if (dp[i][j] != null)
            return dp[i][j];

        int left = piles[i] - helper(piles, i + 1, j);

        int right = piles[j] - helper(piles, i, j - 1);

        return dp[i][j] = Math.max(left, right);
    }
}