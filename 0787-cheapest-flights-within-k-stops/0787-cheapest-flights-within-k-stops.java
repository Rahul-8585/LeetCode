class Solution {

    static class Pair {
        int next, weight;
        Pair(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    static class Triple {
        int stops, node, cost;
        Triple(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Triple it = q.poll();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;

            if (stops > k) continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.next;
                int edw = iter.weight;

                if (cost + edw < dist[adjNode]) {
                    dist[adjNode] = cost + edw;
                    q.add(new Triple(stops + 1, adjNode, cost + edw));
                }
            }
        }

        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }
}
