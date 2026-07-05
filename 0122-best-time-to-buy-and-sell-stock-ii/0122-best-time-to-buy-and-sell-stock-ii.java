class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];

        return helper(prices,0,0,dp);
    }
    /*canbuy = 0 => can buy
    canbuy = 1 => cannot buy*/
    private int helper(int[] nums,int i,int canbuy,Integer[][] dp){

        if(i == nums.length) return 0;
        if(dp[i][canbuy] != null){
            return dp[i][canbuy];
        }
        int profit;
        if(canbuy == 0){
            int buy = -nums[i]+helper(nums,i+1,1,dp);
            int skip = 0+helper(nums,i+1,0,dp);
            profit = Math.max(buy,skip);
        }else{
            int sell = nums[i]+helper(nums,i+1,0,dp);
            int skip = 0+helper(nums,i+1,1,dp);
            profit = Math.max(sell,skip);
        }
        dp[i][canbuy] = profit;
        return dp[i][canbuy];
    }
}