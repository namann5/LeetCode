class Solution {

    int[][] dp;
    int[] stone;

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;
        stone = stoneValue;

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, n - 1);
    }

    int fun(int i, int j) {

        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;

        int[] prefix = new int[stone.length + 1];

        for (int x = 0; x < stone.length; x++) {
            prefix[x + 1] = prefix[x] + stone[x];
        }

        for (int k = i; k < j; k++) {

            int left = prefix[k + 1] - prefix[i];
            int right = prefix[j + 1] - prefix[k + 1];

            if (left < right) {
                res = Math.max(res, left + fun(i, k));

            } else if (right < left) {
                res = Math.max(res, right + fun(k + 1, j));

            } else {
                res = Math.max(
                    res,
                    left + Math.max(fun(i, k), fun(k + 1, j))
                );
            }
        }

        return dp[i][j] = res;
    }
}