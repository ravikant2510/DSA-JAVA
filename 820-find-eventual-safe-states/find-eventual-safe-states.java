class Solution {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,int[] visited, int[] current_path) {
      visited[node] = 1;
      current_path[node] = 1;

      for(int nbr: adj.get(node)) {
        if(visited[nbr] == 0) {
           boolean ans = dfs(nbr, adj,visited,current_path);
           if(ans) {
            return true;
           }
        } else {
            if(current_path[nbr] == 1) {
                return true;
            }
        }
      }
      current_path[node] = 0;
      return false;
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i =0;i<graph.length;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++) {
            for(int j =0;j<graph[i].length;j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] visited = new int[n];
        int[] currentPath = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<n;i++) {
            if(visited[i] ==0) {
                dfs(i,adj,visited, currentPath);
            }
        }
        for(int i =0;i<n;i++) {
            if(currentPath[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}