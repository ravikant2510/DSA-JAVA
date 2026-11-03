class Solution {
    int[] parent;
    int component;
    int find_set(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find_set(parent[x]);
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) {
            return -1;
        }
        this.parent = new int[n];
        this.component = n;
        for(int i=0;i<n;i++) {
            parent[i] =i;
        }
        for(int[] conn:connections) {
            int p1 = find_set(conn[0]);
            int p2 = find_set(conn[1]);
            if(p2 != p1) {
                parent[p2] =p1;
                component--;
            }
        }
        return component-1;
    }
}