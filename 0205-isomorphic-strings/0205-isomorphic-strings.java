class Solution {
    public boolean isIsomorphic(String s, String t) {
        // If lengths are different, they cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Map to store character from 's' -> character from 't'
        HashMap<Character, Character> map = new HashMap<>();
        // Set to track characters in 't' that are already claimed
        HashSet<Character> claimedCharacters = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: We have seen c1 before
            if (map.containsKey(c1)) {
                // It must map to the same character c2 as before
                if (map.get(c1) != c2) {
                    return false;
                }
            } 
            // Case 2: c1 is a brand new character
            else {
                // If c2 is already claimed by a different character in 's', fail
                if (claimedCharacters.contains(c2)) {
                    return false;
                }

                // Establish the 1-to-1 mapping
                map.put(c1, c2);
                claimedCharacters.add(c2);
            }
        }

        return true;
    }
}