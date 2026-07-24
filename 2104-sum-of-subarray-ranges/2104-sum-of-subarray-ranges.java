class Solution {

    public long subArrayRanges(int[] nums) {

        int n = nums.length;

        int[] nse = nextSmaller(nums);
        int[] pse = prevSmallerOrEqual(nums);

        int[] nge = nextGreater(nums);
        int[] pge = prevGreaterOrEqual(nums);

        long sumMin = 0;
        long sumMax = 0;

        // Contribution as Minimum
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            sumMin += (long) nums[i] * left * right;
        }

        // Contribution as Maximum
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;

            sumMax += (long) nums[i] * left * right;
        }

        return sumMax - sumMin;
    }

    // Next Smaller (Strictly Smaller)
    private int[] nextSmaller(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, n);

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }

    // Previous Smaller or Equal
    private int[] prevSmallerOrEqual(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }

    // Next Greater (Strictly Greater)
    private int[] nextGreater(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, n);

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }

    // Previous Greater or Equal
    private int[] prevGreaterOrEqual(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }
}