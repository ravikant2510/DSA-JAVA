class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] vis = new int[isConnected.length];
        for(int i = 0;i<isConnected.length;i++) {
            if(vis[i] == 0) {
                count++;
                dfs(i,isConnected,vis);
            }
        }
        return count;
    }
    private void dfs(int node ,int[][] isConnected ,int[] vis) {
        vis[node] = 1;
        int n = isConnected.length;
        int m = isConnected[0].length;
        for(int i = 0;i<n;i++) {
            for(int j  =0;j<m;j++) {
                if(isConnected[node][j] == 1 && vis[j] == 0) {
                    dfs(j,isConnected,vis);
                }
            }
        }

    }
}