class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgcolor = image[sr][sc];
        dfs(sr,sc,image,orgcolor,color);
        return image;
    }
    private void dfs(int sr,int sc,int[][] image,int orgcolor,int newcolor) {
        image[sr][sc] = newcolor;
        int n = image.length;
        int m = image[0].length;
        for(int k =0;k<4;k++) {
            int newrow = sr+dx[k];
            int newcol = sc+dy[k];
            if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && 
            image[newrow][newcol] != newcolor 
            && image[newrow][newcol] == orgcolor
            )
            dfs(newrow,newcol,image,orgcolor,newcolor);
        }
    }
}