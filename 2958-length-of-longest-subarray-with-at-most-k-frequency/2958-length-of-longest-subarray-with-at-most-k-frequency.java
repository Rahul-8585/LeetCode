class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int r = 0;
        int l = 0;
        int len = 0;
        int max = 0;

        while(r<n){

            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            if(map.get(nums[r]) > k){
                while(map.get(nums[r]) > k){
                    map.put(nums[l],map.get(nums[l])-1);
                    l++;
                }
            }
            len = r-l+1;
            max = Math.max(len,max);
            r++;
        }
        return max;
    }
}