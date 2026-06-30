class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        int ans = high;

        while (low <= high) {

            int mid = (low+high)/2;

            if (count(matrix, mid) >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int count(int[][] matrix, int target) {

        int n = matrix.length;

        int row = n - 1;
        int col = 0;

        int cnt = 0;

        while (row >= 0 && col < n) {

            if (matrix[row][col] <= target) {
                cnt += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return cnt;
    }
}