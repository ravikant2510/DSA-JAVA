class Solution {
    private boolean check(int start,ArrayList<ArrayList<Integer>> adj , int[] color){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        color[start] =0;
        while(!qu.isEmpty()) {
            int node = qu.poll();
            for(int nbr:adj.get(node)) {
                if(color[nbr] == -1){
                    qu.offer(nbr);
                    color[nbr] = 1-color[node]; 
                } else {
                    if(color[nbr] == color[node]) {
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++) {
            for(int j =0;j<graph[i].length;j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++) {
            if(color[i] == -1) {
                if(check(i,adj,color)== false) {
                    return false;
                }
            }
        }
        return true;
    }
}