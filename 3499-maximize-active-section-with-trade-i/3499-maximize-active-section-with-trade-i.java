class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        s = "1" + s + "1";

        int ones = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') ones++;
        }

        int i = 0;
        int prevZero = 0;
        int ans = ones;

        while (i < s.length()) {

            if (s.charAt(i) == '0') {

                int j = i;
                while (j < s.length() && s.charAt(j) == '0')
                    j++;

                prevZero = j - i;
                i = j;
            }
            else {

                int j = i;
                while (j < s.length() && s.charAt(j) == '1')
                    j++;

                int oneLen = j - i;

                if (i > 0 && j < s.length() && s.charAt(i - 1) == '0') {

                    int k = j;
                    while (k < s.length() && s.charAt(k) == '0')
                        k++;

                    if (k > j) {
                        int nextZero = k - j;
                        ans = Math.max(ans, ones + prevZero + nextZero);
                    }
                }

                i = j;
            }
        }

        return ans;
    }
}