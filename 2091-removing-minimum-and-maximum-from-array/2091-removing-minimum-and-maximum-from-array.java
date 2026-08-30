class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find min and max indices
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // 1. Both from left
        int option1 = right + 1;

        // 2. Both from right
        int option2 = n - left;

        // 3. One from left, one from right
        int option3 = (left + 1) + (n - right);

        return Math.min(option1, Math.min(option2, option3));
    }
}