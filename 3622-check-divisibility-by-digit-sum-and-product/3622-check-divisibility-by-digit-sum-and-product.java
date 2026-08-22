class Solution {
    public boolean checkDivisibility(int num) {
        int sum = 0;
        int prod = 1;
        int n = num;
        while(n>0){
            int rem = n%10;
            sum = sum+rem;
            prod = prod*rem;
            n = n/10;
        }
        int tsum = sum+prod;
        if(num%tsum == 0) return true;

        return false;
    }
}