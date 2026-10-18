class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        int res = 0;
        Arrays.sort(position);

        int left = 1;
        int right = position[n - 1] - position[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(position, m, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    private boolean isPossible(int[] position, int m, int minDistance) {
        int n = position.length;
        int lastBallPos = position[0];
        int ballsPlaced = 1;

        for (int i = 1; i < n; i++) {
            if (position[i] - lastBallPos >= minDistance) {
                lastBallPos = position[i];
                ballsPlaced++;

                if (ballsPlaced == m) {
                    return true;
                }
            }
        }

        return false;
    }
}