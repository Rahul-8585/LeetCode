class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        String v = "aeiouAEIOU";

        char[] arr = s.toCharArray();  // IMPORTANT

        int l = 0;
        int r = n - 1;

        while (l <= r) {

            char lc = arr[l];
            char rc = arr[r];

            if (v.contains(lc + "") && v.contains(rc + "")) {
                // swap in char array
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l++;
                r--;
            }
            else if (v.contains(lc + "")) {
                r--;
            }
            else if (v.contains(rc + "")) {
                l++;
            }
            else {
                l++;
                r--;
            }
        }

        return new String(arr);  // return modified string
    }
}
//In Java, appending + "" to a primitive char variable (like lc + "") is a quick, shorthand trick used to convert that character into a String.Works perfectly because adding a character to an empty string forces Java to turn the whole thing into a String