class Solution {
    class Pair{
        int node;
        double cost;
        public Pair(int node, double cost) {
            this.node=node;
            this.cost = cost;
        }

    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Double.compare(b.cost,a.cost)
        );
        
        double[] dist = new double[n];
        Arrays.fill(dist,0.0);
        dist[start_node]=1.0;
        pq.add(new Pair(start_node,1));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node =p.node;
            double cost = p.cost;
            for(Pair nbr_info:adj.get(node)) {
                int nbr = nbr_info.node;
                double newCost = cost*nbr_info.cost;
                if(newCost>dist[nbr]) {
                    dist[nbr] = newCost;
                    pq.add(new Pair(nbr,newCost));
                }
            }
        }
        return dist[end_node] == 0.0?0.0:dist[end_node];

    }
}