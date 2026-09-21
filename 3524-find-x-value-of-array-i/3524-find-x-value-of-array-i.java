class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];
        long[] dp = new long[k];

        for(int x : nums) {

            long[] next = new long[k];

            // Start a new subarray
            next[x % k]++;

            // Extend previous subarrays
            for(int r = 0; r < k; r++) {
                if(dp[r] > 0) {
                    int rem = (int)((r * (long)(x % k)) % k);
                    next[rem] += dp[r];
                }
            }

            // Add current subarrays to answer
            for(int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }
}