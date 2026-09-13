class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int maxOverlap = 0;

        // Try every possible row shift
        for (int rowShift = -(n - 1); rowShift <= n - 1; rowShift++) {

            // Try every possible column shift
            for (int colShift = -(n - 1); colShift <= n - 1; colShift++) {

                int overlap = 0;

                // Check every cell of img1
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        // New position after translation
                        int newRow = i + rowShift;
                        int newCol = j + colShift;

                        // Check if new position is inside img2
                        if (newRow >= 0 && newRow < n &&
                            newCol >= 0 && newCol < n) {

                            // Check if both images have 1
                            if (img1[i][j] == 1 &&
                                img2[newRow][newCol] == 1) {

                                overlap++;
                            }
                        }
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}