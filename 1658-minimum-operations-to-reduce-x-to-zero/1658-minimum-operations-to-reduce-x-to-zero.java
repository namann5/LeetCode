class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        int total = 0;

        for(int num : nums) {
            total += num;
        }

        int target = total - x;

        if(target < 0)
            return -1;

        if(target == 0)
            return n;

        int low = 0;
        int sum = 0;
        int maxLen = -1;

        for(int high = 0; high < n; high++) {

            sum += nums[high];

            while(sum > target && low <= high) {
                sum -= nums[low];
                low++;
            }

            if(sum == target) {
                maxLen = Math.max(maxLen, high - low + 1);
            }
        }

        if(maxLen == -1)
            return -1;

        return n - maxLen;
    }
}