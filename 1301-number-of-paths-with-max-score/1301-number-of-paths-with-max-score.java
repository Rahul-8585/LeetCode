class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = 1000000007;
        int n = board.size();
        
        // dpScore stores the max score from 'S' to (r, c)
        int[][] dpScore = new int[n][n];
        // dpWays stores the number of ways to achieve the max score
        int[][] dpWays = new int[n][n];
        
        // Initialize dpScore with -1 to denote unreachable cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dpScore[i][j] = -1;
            }
        }
        
        // Base case: Starting point 'S' at the bottom-right
        dpScore[n - 1][n - 1] = 0;
        dpWays[n - 1][n - 1] = 1;
        
        // Directions: Down, Right, Down-Right
        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};
        
        // Iterate from bottom-right to top-left
        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                char currentCell = board.get(r).charAt(c);
                
                // Skip obstacles and the starting point
                if (currentCell == 'X' || (r == n - 1 && c == n - 1)) {
                    continue;
                }
                
                int maxPrevScore = -1;
                
                // 1. Find the maximum score from the 3 possible predecessors
                for (int[] d : dirs) {
                    int prevR = r + d[0];
                    int prevC = c + d[1];
                    
                    if (prevR < n && prevC < n && dpScore[prevR][prevC] != -1) {
                        if (dpScore[prevR][prevC] > maxPrevScore) {
                            maxPrevScore = dpScore[prevR][prevC];
                        }
                    }
                }
                
                // 2. If the current cell is reachable from valid predecessors
                if (maxPrevScore != -1) {
                    int ways = 0;
                    
                    // Sum the ways of all predecessors matching the max score
                    for (int[] d : dirs) {
                        int prevR = r + d[0];
                        int prevC = c + d[1];
                        
                        if (prevR < n && prevC < n && dpScore[prevR][prevC] == maxPrevScore) {
                            ways = (ways + dpWays[prevR][prevC]) % MOD;
                        }
                    }
                    
                    dpWays[r][c] = ways;
                    
                    // Add current cell's value (treat 'E' as 0)
                    int currentVal = (currentCell == 'E') ? 0 : (currentCell - '0');
                    // Note: We don't modulo the score during transition because it ruins max comparisons.
                    // The max possible sum is 100 * 100 * 9 = 90,000, which easily fits in a standard int.
                    dpScore[r][c] = maxPrevScore + currentVal;
                }
            }
        }
        
        // If 'E' is unreachable, return [0, 0]
        if (dpScore[0][0] == -1) {
            return new int[]{0, 0};
        }
        
        return new int[]{dpScore[0][0] % MOD, dpWays[0][0]};
    }
}