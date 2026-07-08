class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int mod = 1000000000 + 7;
        int n = s.length();
        int q = queries.length;
        int[] res = new int[q];
        
        // 1. Initialize Prefix Arrays
        long[] prefVal = new long[n + 1];
        long[] prefSum = new long[n + 1];
        int[] cnt = new int[n + 1];
        
        // Precompute powers of 10 modulo 10^9 + 7
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }
        
        // 2. Build the prefix data in O(N) time
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            
            // Sum always updates
            prefSum[i + 1] = prefSum[i] + digit;
            
            // By default, carry over the previous values (for when digit == 0)
            cnt[i + 1] = cnt[i];
            prefVal[i + 1] = prefVal[i];
            
            // Only update length and value if the digit is non-zero
            if (digit != 0) {
                cnt[i + 1] = cnt[i] + 1;
                prefVal[i + 1] = (prefVal[i] * 10 + digit) % mod;
            }
        }
        
        // 3. Answer each query in O(1) time
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            // Find sum of digits in the range
            long sum = prefSum[r + 1] - prefSum[l];
            
            // Find how many non-zero digits are in this range
            int c = cnt[r + 1] - cnt[l];
            
            // Extract the value of the concatenated non-zero digits mathematically
            long x = (prefVal[r + 1] - (prefVal[l] * pow10[c]) % mod + mod) % mod;
            
            // Multiply and apply final modulo
            res[i] = (int) ((x * sum) % mod);
        }
        
        return res;
    }
}