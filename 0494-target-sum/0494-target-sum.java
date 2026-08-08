class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int sum =0;
        for(int x : nums){
            sum += x;
        }
        if(Math.abs(target) > sum) return 0;

        if((sum+target) %2 ==1){
            return 0;
        }

        int ans = (sum + target)/2;
        int [][] dp = new int[n+1][ans+1];
        dp[n][0]=1;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<= ans;j++){
                if(nums[i]>j){
                    dp[i][j]=  dp[i+1][j];
                }else {
                    dp[i][j] = dp[i+1][j-nums[i]] + dp[i+1][j];
                }
            }
        }
        return dp[0][ans];
    }
}