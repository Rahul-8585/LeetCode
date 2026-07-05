class Solution {
    public int maxDigitRange(int[] nums) {
    int[] res = new int[nums.length];
    int max = 0;
    int sum = 0;
    for(int i = 0;i<nums.length;i++){
        res[i] = helper(nums,i);
        System.out.println(res[i]);
        max = Math.max(res[i],max);
    }
    for(int j = 0;j<nums.length;j++){
        if(res[j] == max){
            sum = sum+nums[j];
        }
    }
    return sum;
    }
    private int helper(int[] nums, int i){
        int max = 0;
        int min = Integer.MAX_VALUE;
        int x = nums[i];
        while(x>0){
            int rem = x%10;
            max = Math.max(max,rem);
            min = Math.min(min,rem);
            x = x/10;
        }
        return max-min;
    }
}