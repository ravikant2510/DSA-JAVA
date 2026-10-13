class Solution {
    class Pair{
        int row;
        int col;
        int greater;
        public Pair(int row,int col,int greater) {
            this.row = row;
            this.col = col;
            this.greater = greater;
        }
    }
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       int[][] distVal = new int[n][m];
       for(int[] row :distVal) {
        Arrays.fill(row,Integer.MAX_VALUE);
       }

   
       PriorityQueue<Pair> pq = new PriorityQueue<>(
        (a,b) -> Integer.compare(a.greater,b.greater)
       );
       distVal[0][0] = grid[0][0];
       pq.add(new Pair(0,0,grid[0][0]));
       while(!pq.isEmpty()) {
        Pair pr = pq.poll();
        int row = pr.row;
        int col = pr.col;
        int greater = pr.greater;
        for(int i=0;i<4;i++) {
            int ii = row+dx[i];
            int jj = col+dy[i];

            if(ii<0 || ii>= n || jj<0 || jj>= m) {
                continue;
            }
             int newGreater = Math.max(
                    greater, grid[ii][jj]
                );

                if (newGreater < distVal[ii][jj]) {
                    distVal[ii][jj] = newGreater;
                    pq.offer(new Pair(ii, jj, newGreater));
                }
        }
       }
       return distVal[n-1][m-1];
    }
}