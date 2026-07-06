class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Step 1: Sort the intervals
        // a[0] == b[0] ? b[1] - a[1] -> If start points are equal, sort by end point DESCENDING
        // a[0] - b[0]                -> Otherwise, sort by start point ASCENDING
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

        int remainingCount = 0;
        int maxEnd = -1;

        // Step 2: Iterate through the sorted intervals
        for (int[] interval : intervals) {
            int currentEnd = interval[1];
            
            // If the current interval extends further than our tracked maxEnd, 
            // it is NOT covered.
            if (currentEnd > maxEnd) {
                remainingCount++;
                maxEnd = currentEnd; // Update the furthest end point we've seen
            }
        }

        return remainingCount;
    }
}