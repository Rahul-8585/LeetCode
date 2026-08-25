class Solution {

    int m;
    int n;

    // Up, Right, Down, Left
    int[][] dirs = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    boolean[][] visited;

    // allowed[streetType][direction]
    boolean[][] allowed = {
        {},
        {false, true, false, true},   // Type 1
        {true, false, true, false},   // Type 2
        {false, false, true, true},   // Type 3
        {false, true, true, false},   // Type 4
        {true, false, false, true},   // Type 5
        {true, true, false, false}    // Type 6
    };

    public boolean hasValidPath(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        return dfs(0, 0, grid);
    }

    private boolean dfs(int row, int col, int[][] grid) {

        // If we reached the destination
        if (row == m - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;

        int street = grid[row][col];

        // Check all 4 directions
        for (int d = 0; d < 4; d++) {

            // Current street does not allow movement in this direction
            if (!allowed[street][d]) {
                continue;
            }

            int newRow = row + dirs[d][0];
            int newCol = col + dirs[d][1];

            // Check boundaries
            if (newRow < 0 || newRow >= m ||
                newCol < 0 || newCol >= n) {
                continue;
            }

            // Skip already visited cells
            if (visited[newRow][newCol]) {
                continue;
            }

            int nextStreet = grid[newRow][newCol];

            // Find opposite direction
            int opposite = (d + 2) % 4;

            // Next street must connect back
            if (allowed[nextStreet][opposite]) {

                if (dfs(newRow, newCol, grid)) {
                    return true;
                }
            }
        }

        return false;
    }
}