class Solution {
    public long smallestNumber(long num) {

        if (num == 0) return 0;

        boolean negative = num < 0;

        char[] digits = Long.toString(Math.abs(num)).toCharArray();

        Arrays.sort(digits);

        if (!negative) {

            // Move first non-zero digit to front
            int i = 0;
            while (digits[i] == '0') i++;

            char temp = digits[0];
            digits[0] = digits[i];
            digits[i] = temp;

        } else {

            // Reverse to descending order
            int left = 0;
            int right = digits.length - 1;

            while (left < right) {
                char temp = digits[left];
                digits[left] = digits[right];
                digits[right] = temp;
                left++;
                right--;
            }
        }

        long ans = Long.parseLong(new String(digits));

        return negative ? -ans : ans;
    }
}