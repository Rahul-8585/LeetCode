class Solution {
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        Integer[][] dp = new Integer[n][m];

        return solve(s, t, 0, 0, dp);
    }

    public int solve(String s, String t, int i, int j, Integer[][] dp) {

        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int ans;

        if (s.charAt(i) == t.charAt(j)) {
            ans = solve(s, t, i + 1, j + 1, dp)
                + solve(s, t, i + 1, j, dp);
        } else {
            ans = solve(s, t, i + 1, j, dp);
        }

        return dp[i][j] = ans;
    }
}
/*
class Solution {
    public int numDistinct(String s, String t) {
        return solve(s, t, 0, 0);
    }

    public int solve(String s, String t, int i, int j) {

        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        int a = 0;

        if (s.charAt(i) == t.charAt(j)) {
            a = solve(s, t, i + 1, j + 1);
        }

        int b = solve(s, t, i + 1, j);

        return a + b;
    }
}
*/