class Solution {
    class Pair {
        int greater;
        int row;
        int column;

        public Pair(int greater, int row, int column) {
            this.greater = greater;
            this.row = row;
            this.column = column;
        }
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.greater, b.greater)
        );

        int[][] distval = new int[n][m];

        for (int[] row : distval) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distval[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair pr = pq.poll();

            int dist_of_par = pr.greater;
            int x = pr.row;
            int y = pr.column;

            for (int k = 0; k < 4; k++) {
                int ii = x + dx[k];
                int jj = y + dy[k];

                if (ii < 0 || jj < 0 || ii >= n || jj >= m) {
                    continue;
                }

                int newDist = Math.max(
                    dist_of_par,
                    Math.abs(heights[x][y] - heights[ii][jj])
                );

                if (newDist < distval[ii][jj]) {
                    distval[ii][jj] = newDist;
                    pq.offer(new Pair(newDist, ii, jj));
                }
            }
        }

        return distval[n-1][m-1];
    }
}
