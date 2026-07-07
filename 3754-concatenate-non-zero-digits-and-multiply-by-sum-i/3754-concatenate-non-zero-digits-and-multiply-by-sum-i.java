class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0){
            return 0;
        }

        long x = 0;
        int sum = 0;
        long place = 1;

        while(n > 0){
            int rem = n % 10;

            if(rem != 0){
                x = rem * place + x;
                place *= 10;
                sum += rem;
            }

            n /= 10;
        }

        return x * sum;
    }
}