class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        Queue<Pair> qu = new LinkedList<>();

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    qu.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;

        while (!qu.isEmpty()) {

            int size = qu.size();

            while (size-- > 0) {

                Pair p = qu.poll();

                int row = p.first;
                int col = p.second;

                for (int[] dir : directions) {

                    int ii = row + dir[0];
                    int jj = col + dir[1];

                    if (ii < 0 || jj < 0 ||
                        ii >= n || jj >= m ||
                        visited[ii][jj]) {
                        continue;
                    }

                    if (mat[ii][jj] == 1) {
                        mat[ii][jj] = level + 1;
                    }
                    visited[ii][jj] = true;

                    qu.offer(new Pair(ii, jj));
                }
            }
            level++;
        }

        return mat;
    }
}