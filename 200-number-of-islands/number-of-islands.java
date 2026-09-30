class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        int cnt =0;

        for(int i =0;i<grid.length;i++) {
            for(int j =0;j<grid[0].length;j++) {
                if(grid[i][j] =='1') {
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
    private void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] ='2';
        for(int k =0;k<4;k++) {
            int ii = i+dx[k];
            int jj = j+dy[k];
            dfs(grid,ii,jj);
        }
    }
}