class Solution {

    Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        dp = new Integer[n];

        int diff = solve(stoneValue, 0);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";
        else
            return "Tie";
    }


    private int solve(int[] stones, int idx) {

        if (idx >= stones.length) {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }


        int max = Integer.MIN_VALUE;
        int sum = 0;


        for (int take = 1; take <= 3; take++) {

            if (idx + take > stones.length)
                break;

            sum += stones[idx + take - 1];

            // current player score - opponent score
            max = Math.max(max,
                    sum - solve(stones, idx + take));
        }


        return dp[idx] = max;
    }
}