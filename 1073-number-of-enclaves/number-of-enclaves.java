class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    private void dfs(int[][] grid,int i,int j, boolean[][] visited) {
        visited[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int k =0;k<4;k++) {
            int ii = i+dx[k];
            int jj = j+dy[k];
            if(ii>=0 && ii<n && jj>=0 && jj<m && grid[ii][jj] == 1 && !visited[ii][jj]) {
                dfs(grid,ii,jj,visited);
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        for(int i =0;i<m;i++) {
            // first row
            if(grid[0][i] == 1 && !visited[0][i]) { 
                dfs(grid,0,i,visited);
            }
             //  last row 
            if(grid[n-1][i] == 1 && !visited[n-1][i]) { 
                dfs(grid,n-1,i,visited);
            }

        }
       
        for(int i=0;i<n;i++) {
           if(grid[i][0] == 1 && !visited[i][0])  {
              dfs(grid,i,0,visited);
           }
           if(grid[i][m-1] == 1 && !visited[i][m-1]) {
            dfs(grid,i,m-1,visited);
           }
        }
        int cnt =0;
        for(int i =0;i<n;i++) {
            for(int j =0;j<m;j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    
    }
}