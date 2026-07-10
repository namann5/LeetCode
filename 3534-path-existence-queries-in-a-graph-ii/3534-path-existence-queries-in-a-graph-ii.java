class Solution {
   public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        // {value, originalIndex}
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // position of every original index in sorted array
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[arr[i][1]] = i;
        }

        // far[i] = farthest position reachable in one edge
        int[] far = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && arr[j + 1][0] - arr[i][0] <= maxDiff) {
                j++;
            }
            far[i] = j;
        }

        // component ending index
        int[] compEnd = new int[n];
        int end = 0;
        while (end < n) {
            int reach = far[end];
            int k = end;
            while (k <= reach) {
                reach = Math.max(reach, far[k]);
                k++;
            }
            for (int t = end; t <= reach; t++) {
                compEnd[t] = reach;
            }
            end = reach + 1;
        }

        int LOG = 18; // 2^17 > 1e5
        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++)
            up[0][i] = far[i];

        for (int p = 1; p < LOG; p++) {
            for (int i = 0; i < n; i++) {
                up[p][i] = up[p - 1][up[p - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int a = pos[queries[q][0]];
            int b = pos[queries[q][1]];

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            if (compEnd[a] < b) {
                ans[q] = -1;
                continue;
            }

            if (a == b) {
                ans[q] = 0;
                continue;
            }

            int cur = a;
            int res = 0;

            for (int p = LOG - 1; p >= 0; p--) {
                if (up[p][cur] < b) {
                    cur = up[p][cur];
                    res += 1 << p;
                }
            }

            ans[q] = res + 1;
        }

        return ans;
    }
}