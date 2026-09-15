class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) &&
                   (j - i < 2 || res[i + 1][j - 1])) {
                    res[i][j] = true;
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            for(int j = i + k - 1; j < n; j++) {
                if(res[i][j])
                    dp[i] = Math.max(dp[i], 1 + dp[j + 1]);
            }
        }

        return dp[0];
    }
}