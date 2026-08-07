class Solution {
    public int smallestNumber(int n, int t) {
        
        while(n<=100){
            int prod = 1;
            int num = n;
            while(num>0){
                int rem = num%10;
                prod = prod*rem;
                num = num/10;
            }
            if(prod % t == 0) return n;

            n++;
        }
        return -1;
    }
}