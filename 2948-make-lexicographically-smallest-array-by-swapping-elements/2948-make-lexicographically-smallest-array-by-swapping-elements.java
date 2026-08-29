class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // value + original index
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int i = 0;

        while (i < n) {

            int j = i;

            // Find one group
            while (j + 1 < n &&
                   arr[j + 1][0] - arr[j][0] <= limit) {
                j++;
            }

            // Store original indices
            int[] indices = new int[j - i + 1];

            for (int k = i; k <= j; k++) {
                indices[k - i] = arr[k][1];
            }

            // Sort original indices
            Arrays.sort(indices);

            // Put smallest values at smallest indices
            for (int k = 0; k < indices.length; k++) {
                nums[indices[k]] = arr[i + k][0];
            }

            i = j + 1;
        }

        return nums;
    }
}