
class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        int[][] arr = new int[n][2];

        // value + original index
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort according to value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int start = 0;

        while (start < n) {

            int end = start;

            // Find the complete group
            while (end + 1 < n &&
                   arr[end + 1][0] - arr[end][0] <= limit) {

                end++;
            }

            // Store original indices
            int[] indices = new int[end - start + 1];

            for (int i = start; i <= end; i++) {
                indices[i - start] = arr[i][1];
            }

            // Put smaller values at smaller indices
            Arrays.sort(indices);

            for (int i = start; i <= end; i++) {
                nums[indices[i - start]] = arr[i][0];
            }

            start = end + 1;
        }

        return nums;
    }
}