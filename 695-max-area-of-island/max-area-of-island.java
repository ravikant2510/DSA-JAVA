class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int maxAreaOfIsland(int[][] grid) {
        int area =0;
        int ans =0;
        for(int i =0;i<grid.length;i++) {
            for(int j =0;j<grid[0].length;j++) {
                if(grid[i][j] ==1) {
                    int currentArea = dfs(grid,i,j);
                    area = Math.max(area,currentArea);
                }
            }
        }
        return area;
        
    }
    private int dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] =2;
        int area =1;
        for(int k =0;k<4;k++) {
            int ii = i+dx[k];
            int jj = j+dy[k];
           area += dfs(grid,ii,jj);
        }
        return area;
    }
}