class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                int idx = i * m + j;

                int newIdx = (idx + k) % (n * m);

                int row = newIdx / m;
                int col = newIdx % m;

                ans[row][col] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                temp.add(ans[i][j]);
            }

            res.add(temp);
        }

        return res;
    }
}