class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] vis = new boolean[n];

        for(int j = 0;j<n;j++){

            if(!vis[j]){

            int[] result = dfs(j,adj,vis);
            int vertices = result[0];
            int edgeCount = result[1] / 2;

            int requiredEdges = vertices * (vertices - 1) / 2;
            if(edgeCount == requiredEdges){
                count++;
            }
            }
        }
        return count;
    }
    public int[] dfs(int node , List<List<Integer>> adj, boolean[] vis){

        vis[node] = true;
         int vertices = 1;
        int edgeCount = adj.get(node).size();

        for(int a : adj.get(node)){
             if (!vis[a]) {

                int[] result = dfs(a,adj,vis);

                vertices += result[0];
                edgeCount += result[1];
            }
        }
         return new int[]{vertices, edgeCount};
    }
}