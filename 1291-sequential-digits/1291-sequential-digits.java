class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
         // The master string containing all possible sequential digits
        String digits = "123456789";
        List<Integer> result = new ArrayList<>();

        // Determine the minimum and maximum lengths we need to look for
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();

        // Step 1: Iterate through the possible lengths of our target numbers
        for (int length = lowLength; length <= highLength; length++) {
            
            // Step 2: Slide a "window" of that length across the master string
            // 9 - length ensures we don't go out of bounds (e.g., if length is 3, start max is index 6 for "789")
            for (int start = 0; start <= 9 - length; start++) {
                
                // Extract the substring
                String sequence = digits.substring(start, start + length);
                
                // Convert it back to an integer
                int num = Integer.parseInt(sequence);
                
                // Step 3: Check if it falls within our required range
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        // Because we iterate by length first, and then from left to right in the string,
        // the numbers are naturally generated in sorted order!
        return result;
    }
}