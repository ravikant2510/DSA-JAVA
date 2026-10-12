class Solution {
    class Pair{
        int node;
        int cost;
        int stops;
        public Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] flts:flights) {
            adj.get(flts[0]).add(new Pair(flts[1],flts[2],0));
        }
        Queue<Pair> qu = new LinkedList<>();
        int[] dest = new int[n];
        Arrays.fill(dest,Integer.MAX_VALUE);
        dest[src] =0;
        qu.offer(new Pair(src,0,0));
        while(!qu.isEmpty()) {
            Pair pr = qu.poll();
            int node = pr.node;
            int cost = pr.cost;
            int stops = pr.stops;
            for(Pair nbr:adj.get(node)) {
                int next = nbr.node;
                int newCost = cost+nbr.cost;

                if(stops>k) {
                    continue;
                }

                if(newCost<dest[next]) {
                    dest[next] = newCost;
                    qu.offer(new Pair(next,newCost,stops+1));
                }
            }
        }
        return dest[dst]==Integer.MAX_VALUE?-1:dest[dst];
    }
}