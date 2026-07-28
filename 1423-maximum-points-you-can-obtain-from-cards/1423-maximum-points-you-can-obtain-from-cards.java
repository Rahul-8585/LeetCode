class Solution {
    public int maxScore(int[] cd, int k) {
        
        int n = cd.length;
        int total = 0;
        int size = n-k;
        for(int a : cd){
            total += a;
        }
        if(k == n) return total;

        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while(r<n){
            sum = sum+cd[r];

            while(r-l+1 > size){
                sum = sum - cd[l];
                l++;
            }
            if(r-l+1 == size){
            min = Math.min(min,sum);
            }
            r++;
        }
        return total-min;
    }
}