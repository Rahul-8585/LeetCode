class Solution {
    public String smallestPalindrome(String s) {

        // Step 1: Store frequency of every character
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Build left half
        StringBuilder left = new StringBuilder();

        // Step 3: Store middle character (if any)
        char middle = '\0';

        // Iterate from 'a' to 'z' to ensure lexicographically smallest order
        for (char ch = 'a'; ch <= 'z'; ch++) {

            if (!map.containsKey(ch))
                continue;

            int freq = map.get(ch);

            // Put half of the occurrences in left half
            for (int i = 0; i < freq / 2; i++) {
                left.append(ch);
            }

            // If frequency is odd, this character goes in the middle
            if (freq % 2 == 1) {
                middle = ch;
            }
        }

        // Step 4: Right half is reverse of left
        StringBuilder right = new StringBuilder(left);
        right.reverse();

        // Step 5: Build answer
        if (middle == '\0') {
            return left.toString() + right.toString();
        }

        return left.toString() + middle + right.toString();
    }
}