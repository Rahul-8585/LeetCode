class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for(int a : nums){
            if(a>max){
                smax = max;
                max = a;
            }
            else if(a>smax){
                smax = a;
            }
        }
        return (max-1)*(smax-1);
    }
}