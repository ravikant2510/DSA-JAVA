class Solution {
    private int comp_count=0;
    private int[] parent,rank;
    int find_set(int v) {
        if(parent[v] ==v) {
            return v;
        }
        return parent[v] = find_set(parent[v]);
    }
    void union_set(int a, int b) {
        a = find_set(a);
        b = find_set(b);
        if(a != b) {
            if(rank[a] >rank[b]) {
                parent[b] = a;
            } else if(rank[a] <rank[b]){
                parent[a] =b;
            } else {
                parent[a] = b;
                rank[b]++;
            }
            comp_count--;
        }
    }
    public int count() {
        return comp_count;
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        this.parent = new int[n];
        this.rank = new int[n];
        this.comp_count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(isConnected[i][j] ==1) {
                    union_set(i,j);
                }
            }
        }
        return count();
    }
}