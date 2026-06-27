class Solution {
    public int maximumLength(int[] nums) {
      // Step 1: Count frequencies of all numbers
        Map<Long, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put((long) num, countMap.getOrDefault((long) num, 0) + 1);
        }

        int maxLen = 1; // Any single element can form a valid subset of length 1

        // Step 2: Handle special case for number 1
        if (countMap.containsKey(1L)) {
            int count1 = countMap.get(1L);
            // The subset size must be odd. If even, take count1 - 1
            if (count1 % 2 == 0) {
                maxLen = Math.max(maxLen, count1 - 1);
            } else {
                maxLen = Math.max(maxLen, count1);
            }
        }

        // Step 3: Process all other numbers
        for (long x : countMap.keySet()) {
            if (x == 1) continue;

            int currentLen = 0;
            long temp = x;

            // We can continue expanding the pattern if the current number appears >= 2 times
            while (countMap.containsKey(temp) && countMap.get(temp) >= 2) {
                currentLen += 2;
                temp = temp * temp; // Move to the next square

                // Break early if temp overflows or gets ridiculously large
                if (temp > 1_000_000_000L) break; 
            }

            // The final 'peak' element only needs to appear at least 1 time
            if (countMap.containsKey(temp) && countMap.get(temp) >= 1) {
                currentLen += 1;
            } else {
                // If the peak doesn't exist, we must subtract 2 because the last 
                // element we processed cannot be a duplicate wrapper; one of them must act as the peak.
                currentLen -= 1; 
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}