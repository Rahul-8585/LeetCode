class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;
        int[] prefix = new int[n + 1];

        // prefix[i] = number of target's in nums[0...i-1]
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i];
            if (nums[i] == target) {
                prefix[i + 1]++;
            }
        }

        int ans = 0;

        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {

                int cnt = prefix[r + 1] - prefix[l];
                int len = r - l + 1;

                if (cnt > len / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}