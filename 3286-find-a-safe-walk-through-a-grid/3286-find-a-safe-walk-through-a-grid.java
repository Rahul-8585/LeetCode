class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        // best[i][j] = maximum health remaining when reaching (i,j)
        int[][] best = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(best[i], -1);
        }

        // Starting health
        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0)
            return false;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            int hp = curr[2];

            // Reached destination
            if (row == n - 1 && col == m - 1)
                return true;

            for (int k = 0; k < 4; k++) {

                int nr = row + dr[k];
                int nc = col + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                int newHealth = hp - grid.get(nr).get(nc);

                // Cannot enter this cell
                if (newHealth <= 0)
                    continue;

                // Only visit if this path gives more remaining health
                if (newHealth > best[nr][nc]) {
                    best[nr][nc] = newHealth;
                    q.offer(new int[]{nr, nc, newHealth});
                }
            }
        }

        return false;
    }
}