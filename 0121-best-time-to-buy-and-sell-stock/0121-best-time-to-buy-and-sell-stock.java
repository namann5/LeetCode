class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int k = 2;

        int[][] dp = new int[n + 1][k + 1];

        for (int i = n - 1; i >= 0; i--) {

            // k = 1 -> sell
            int sell = prices[i] + dp[i + 1][0];
            int skipSell = dp[i + 1][1];

            dp[i][1] = Math.max(sell, skipSell);

            // k = 2 -> buy
            int buy = -prices[i] + dp[i + 1][1];
            int skipBuy = dp[i + 1][2];

            dp[i][2] = Math.max(buy, skipBuy);
        }

        return dp[0][2];
    }
}