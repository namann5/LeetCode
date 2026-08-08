class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for (int x : nums) {
         sum += x;
        }
         if(sum%2 == 1){
            return false;
         }

          int target = sum / 2;
        int[][] dp = new int[n+1][target+1];
       dp[n][0]=1;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<= target;j++){
                if(nums[i]>j){
                    dp[i][j]= dp[i+1][j];
                }else {
                    dp[i][j] = Math.max(dp[i+1][j-nums[i]], dp[i+1][j]);
                }
            }
        }
        return dp[0][target]==1;
    }
}