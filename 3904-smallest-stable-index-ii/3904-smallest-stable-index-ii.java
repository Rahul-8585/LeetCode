class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int n = nums.length;
        int[] pm = new int[n];
        int[] sm = new int[n];
        pm[0] = nums[0];
        sm[n-1] = nums[n-1];

        for(int i = 1;i<n;i++){
            if(nums[i] > pm[i-1]){
                pm[i] = nums[i];
            }else{
                pm[i] = pm[i-1];
            }
            if(nums[(n-1)-i] < sm[(n-1)-i+1]){
                sm[(n-1)-i] = nums[(n-1)-i];
            }else{
                sm[(n-1)-i] = sm[(n-1)-i+1];
            }
        }

        for(int j = 0;j<n;j++){
            if((pm[j] - sm[j]) <= k){
                return j;
            }
        }
        return -1;
    }
}