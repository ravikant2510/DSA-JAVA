class Solution {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        Queue<Pair> qu = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                visited[0][j] = true;
                qu.offer(new Pair(0, j));
            }
        }

        for (int j = 0; j < m; j++) {
            if (board[n - 1][j] == 'O' && !visited[n - 1][j]) {
                visited[n - 1][j] = true;
                qu.offer(new Pair(n - 1, j));
            }
        }

        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O' && !visited[i][0]) {
                visited[i][0] = true;
                qu.offer(new Pair(i, 0));
            }

            if (board[i][m - 1] == 'O' && !visited[i][m - 1]) {
                visited[i][m - 1] = true;
                qu.offer(new Pair(i, m - 1));
            }
        }

        
        while (!qu.isEmpty()) {

            Pair p = qu.poll();

            int row = p.first;
            int col = p.second;

            for (int k = 0; k < 4; k++) {

                int nr = row + dx[k];
                int nc = col + dy[k];

                if (nr < 0 || nc < 0 ||
                    nr >= n || nc >= m ||
                    visited[nr][nc]) {
                    continue;
                }

                if (board[nr][nc] == 'O') {
                    visited[nr][nc] = true;
                    qu.offer(new Pair(nr, nc));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}