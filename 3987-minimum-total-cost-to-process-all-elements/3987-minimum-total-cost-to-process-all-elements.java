class Solution {
    public int minimumCost(int[] nums, int k) {
        long y = k;
        long op = 1;
        long resource = k;

        long mod = 1000000007;
        long inv2 = 500000004; // inverse of 2 modulo mod

        long cost = 0;

        for (int x : nums) {
            if (resource < x) {
                long need = x - resource;
                long cnt = (need + y - 1) / y;

                resource += cnt * y;

                long a = (2 * (op % mod)) % mod;
                long b = (cnt - 1) % mod;
                long c = cnt % mod;

                long sum = (((a + b) % mod) * c) % mod;
                sum = (sum * inv2) % mod;

                cost = (cost + sum) % mod;

                op += cnt;
            }

            resource -= x;
        }

        return (int) cost;
    }
}