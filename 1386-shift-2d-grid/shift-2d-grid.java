class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;
        int x = m * n;

        int[] arr = new int[x];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        int l = arr.length;
        k %= l;

        reverse(0, l - 1, arr);
        reverse(0, k - 1, arr);
        reverse(k, l - 1, arr);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            if (i != 0 && i % n == 0) {
                result.add(list);
                list = new ArrayList<>();
            }
            list.add(arr[i]);
        }

        result.add(list);

        return result;
    }
    private void reverse(int left, int right, int[] arr) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}