class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int c = 0;
        int[] in = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            for(int a : adj.get(i)){
                in[a] = in[a]+1;
            }
        }
        for(int i = 0;i<n;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            c++;
            for(int a : adj.get(node)){
                in[a]--;
                if(in[a] == 0){
                    q.add(a);
                }
            }
        }
        if(c == n){
            return true;
        }
        return false;
    }
}