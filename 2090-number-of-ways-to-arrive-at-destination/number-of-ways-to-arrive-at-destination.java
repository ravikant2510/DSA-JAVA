class Solution {
    class Pair {
        int node;
        long cost;

        public Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int cost = road[2];

            adj.get(u).add(new Pair(v, cost));
            adj.get(v).add(new Pair(u, cost));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.cost, b.cost)
        );

        long[] dist = new long[n];
        int[] ways = new int[n];
        int mod = 1_000_000_007;

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0L;
        ways[0] = 1;
        pq.offer(new Pair(0, 0L));

        while (!pq.isEmpty()) {
            Pair pr = pq.poll();

            int node = pr.node;
            long cost = pr.cost;

            if (cost > dist[node]) {
                continue;
            }

            for (Pair nbr : adj.get(node)) {
                int next = nbr.node;
                long newCost = cost + nbr.cost;

                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    ways[next] = ways[node];

                    pq.offer(new Pair(next, newCost));
                } else if (newCost == dist[next]) {
                    ways[next] = (int) (
                        ((long) ways[next] + ways[node]) % mod
                    );
                }
            }
        }

        return ways[n - 1];
    }
}
