class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int ans = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        int[][] cnt = new int[n][26];
        int[] Indegree = new int[n];
        for(int[] edge:edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            Indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(Indegree[i] ==0) {
                q.offer(i);
            }
        }
        int processed =0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            processed++;
            cnt[node][colors.charAt(node)-'a']++;
            ans = Math.max(ans,cnt[node][colors.charAt(node)-'a']);

            for(int nbr:graph.get(node)) {
                Indegree[nbr]--;
                if(Indegree[nbr] ==0) {
                    q.offer(nbr);
                }
                for(int j =0;j<26;j++) {
                    cnt[nbr][j] = Math.max(cnt[nbr][j],cnt[node][j]);
                }
            }
        }
        return processed==n?ans:-1;
    }
}