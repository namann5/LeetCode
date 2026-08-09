class Solution {

    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return fun(piles, n, 0, 1);
    }

    int fun(int[] piles, int n, int i, int M) {

        if (i >= n) {
            return 0;
        }

        if (2 * M >= n - i) {
            return suffix[i];
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int ans = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int opponent = fun(
                piles,
                n,
                i + X,
                Math.max(M, X)
            );

            int current = suffix[i] - opponent;

            ans = Math.max(ans, current);
        }

        return dp[i][M] = ans;
    }
}