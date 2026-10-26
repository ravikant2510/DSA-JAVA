class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int closedIsland(int[][] grid) {
        for(int i =0;i<grid.length;i++) {
            if(grid[i][0] == 0) {
                dfs(grid,i,0);
            }
            if(grid[i][grid[0].length-1] == 0) {
                dfs(grid,i,grid[0].length-1);
            }
        }
        for(int i=0;i<grid[0].length;i++) {
            if(grid[0][i] ==0) {
                dfs(grid,0,i);
            }
            if(grid[grid.length-1][i] ==0) {
                dfs(grid,grid.length-1,i);
            }
        }
        int ans =0;
        for(int i =0;i<grid.length;i++) {
            for(int j =0;j<grid[0].length;j++) {
                if(grid[i][j] ==0) {
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] grid , int i, int j) {
       if(i < 0 || i >= grid.length ||
        j < 0 || j >= grid[0].length || grid[i][j] == 1) return;
        grid[i][j] = 1;
        for(int k =0;k<4;k++) {
            dfs(grid,i+dx[k],j+dy[k]);
        }
    }
}