class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] inv) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : inv) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Mark all suspicious methods
        boolean[] suspicious = new boolean[n];
        dfs(k, adj, suspicious);

        // If any non-suspicious method invokes a suspicious method,
        // we cannot remove any suspicious methods.
        for (int[] edge : inv) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // Otherwise, remove all suspicious methods
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] suspicious) {
        suspicious[node] = true;

        for (int next : adj.get(node)) {
            if (!suspicious[next]) {
                dfs(next, adj, suspicious);
            }
        }
    }
}