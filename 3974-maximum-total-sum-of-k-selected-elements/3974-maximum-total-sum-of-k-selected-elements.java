class Solution {
    public long maxSum(int[] nums, int k, int mul) {

        Arrays.sort(nums);

        long ans = 0;

        int useful = Math.min(k, Math.max(0, mul - 1));

        int idx = nums.length - 1;

        // Use the beneficial multipliers
        for (int i = 0; i < useful; i++) {
            ans += 1L * nums[idx--] * (mul - i);
        }

        // Remaining selected elements are added normally
        while (idx >= nums.length - k) {
            ans += nums[idx--];
        }

        return ans;
    }
}