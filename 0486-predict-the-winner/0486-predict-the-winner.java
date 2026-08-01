class Solution {

    Integer[][] dp;

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        dp = new Integer[n][n];

        return helper(nums, 0, n - 1) >= 0;
    }

    private int helper(int[] nums, int i, int j) {

        if (i == j)
            return nums[i];

        if (dp[i][j] != null)
            return dp[i][j];

        int pickLeft = nums[i] - helper(nums, i + 1, j);

        int pickRight = nums[j] - helper(nums, i, j - 1);

        return dp[i][j] = Math.max(pickLeft, pickRight);
    }
}