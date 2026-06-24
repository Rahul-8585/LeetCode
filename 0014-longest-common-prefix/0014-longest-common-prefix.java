class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // 1. Find the length of the shortest string
        int minLength = findMinLength(strs);

        // 2. Loop vertically character by character up to minLength
        for (int i = 0; i < minLength; i++) {
            char currentCh = strs[0].charAt(i); // Take character from the first string
            
            // Compare this character with the same position in all other strings
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentCh) {
                    // Mismatch found! Return everything up to this index
                    return strs[0].substring(0, i);
                }
            }
        }

        // If we finished the loop, the entire shortest string is the prefix
        return strs[0].substring(0, minLength);
    }

    // Helper function to find the minimum string length
    public int findMinLength(String[] strs) {
        int min = Integer.MAX_VALUE; 
        
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length(); // Store the minimum length
            }
        }
        return min;
    }
}