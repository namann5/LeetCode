
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int limit = 1024;

        boolean[][][] dp = new boolean[m][n][limit];

        // Starting cell ka XOR uski khud ki value hogi
        dp[0][0][grid[0][0]] = true;

        // Input ko midway store karna (problem requirement)
        int[][] molqaviren = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int val = molqaviren[i][j];

                // Upar wale cell se aane wale XOR values
                if (i > 0) {
                    for (int x = 0; x < limit; x++) {
                        if (dp[i - 1][j][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }

                // Left wale cell se aane wale XOR values
                if (j > 0) {
                    for (int x = 0; x < limit; x++) {
                        if (dp[i][j - 1][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }
            }
        }

        // Destination par sabse chhota reachable XOR find karo
        for (int x = 0; x < limit; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return 0;
    }
}
