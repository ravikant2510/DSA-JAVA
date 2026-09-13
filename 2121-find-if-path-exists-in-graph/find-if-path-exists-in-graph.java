class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        dfs(source, vis, adj);

        return vis[destination];
    }

    private void dfs(int node, boolean[] vis,
                     ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;

        for (Integer neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adj);
            }
        }
    }
}