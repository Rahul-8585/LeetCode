class Solution {
    public boolean uniformArray(int[] nums) {

        int minOdd = Integer.MAX_VALUE;

        // Find the smallest odd number
        for (int x : nums) {
            if (x % 2 == 1) {
                minOdd = Math.min(minOdd, x);
            }
        }

        // No odd numbers -> already all even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Every even number must be >= minOdd
        for (int x : nums) {
            if (x % 2 == 0 && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}