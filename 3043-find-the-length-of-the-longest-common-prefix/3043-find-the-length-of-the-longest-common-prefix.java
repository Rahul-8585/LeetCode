
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        
        // Step 1: Store all possible prefixes from arr1
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check prefixes from arr2 against the set
        for (int num : arr2) {
            while (num > 0) {
                if (prefixes.contains(num)) {
                    // String.valueOf efficiently gives us the length of the matched integer
                    maxLength = Math.max(maxLength, String.valueOf(num).length());
                    
                    // We break early because checking downward guarantees 
                    // the first match is the longest possible for this number
                    break; 
                }
                num /= 10;
            }
        }
        
        return maxLength;
    }
}