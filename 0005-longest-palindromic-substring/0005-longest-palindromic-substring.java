class Solution {

    int maxLen = 0;
    int start = 0;

    public String longestPalindrome(String s) {

        String t = reverse(s);

        int[][] dp = new int[s.length()][s.length()];

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                helper(s, t, i, j, dp);
            }
        }

        return s.substring(start, start + maxLen);
    }


    private int helper(String s, String t, int i, int j, int[][] dp) {

        if (i == s.length() || j == t.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }


        if (s.charAt(i) == t.charAt(j)) {

            int len = 1 + helper(s, t, i + 1, j + 1, dp);

            // original starting index in s
            int originalStart = i;

            // position in original string corresponding to j in reversed string
            int reverseStart = s.length() - 1 - (j + len - 1);


            // Check if it is actually palindrome
            if (originalStart == reverseStart) {

                if (len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }

            return dp[i][j] = len;
        }

        return dp[i][j] = 0;
    }


    public String reverse(String s) {

        char[] c = s.toCharArray();  // fixed

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {

            char temp = c[l];
            c[l] = c[r];
            c[r] = temp;

            l++;
            r--;
        }

        return new String(c);
    }
}