class Solution {
    public int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int tmax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        int tmin = Integer.MAX_VALUE;

        for(int a : nums){

            if(a>max){
                tmax = smax;
                smax = max;
                max = a;
            }
            else if(a>smax){
                tmax = smax;
                smax = a;
            }
            else if(a>tmax){
                tmax = a;
            }
            if(a < min){
                tmin = smin;
                smin = min;
                min = a;
            }
            else if(a < smin){
                tmin = smin;
                smin = a;
            }
            else if(a<tmin){
                tmin = a;
            }
        }

        int prod1 = max*smax*tmax;
        int prod2 = min*smin*max;

        return Math.max(prod1,prod2);
    }
}