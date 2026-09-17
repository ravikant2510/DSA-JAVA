class Solution {
    public int dfs(int node, ArrayList<ArrayList<Integer>> forward, ArrayList<ArrayList<Integer>> backward, int ans, int[] visited) {
        visited[node] = 1;
        for(Integer nbr: forward.get(node)) {
            if(visited[nbr] == 0) {
                ans++;
                ans=dfs(nbr, forward,backward,ans,visited);
            }
        }
        for(Integer nbr: backward.get(node)) {
            if(visited[nbr] == 0) {
                ans=dfs(nbr, forward,backward,ans,visited);
            }
        }
        return ans;
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> forward = new ArrayList<>();
        ArrayList<ArrayList<Integer>> backward = new ArrayList<>();
        int[] visited = new int[n];
        for(int i =0;i<n;i++) {
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        } 
        for(int i =0;i<connections.length;i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            forward.get(a).add(b);
            backward.get(b).add(a);
        }
        int ans =0;
        ans = dfs(0,forward,backward,ans,visited);
        return ans;
    }
}