import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (a[mid][0] > a[i][1])
                    high = mid;
                else
                    low = mid + 1;
            }

            next[i] = low;
        }

        long[][] dp = new long[n + 1][5];
        int[][][] ans = new int[n + 1][5][];

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {

                long skip = dp[i + 1][k];

                long take = a[i][2] + dp[next[i]][k - 1];

                if (take > skip) {
                    dp[i][k] = take;
                    ans[i][k] = add(a[i][3], ans[next[i]][k - 1]);
                } 
                else if (take < skip) {
                    dp[i][k] = skip;
                    ans[i][k] = ans[i + 1][k];
                } 
                else {
                    int[] x = add(a[i][3], ans[next[i]][k - 1]);
                    int[] y = ans[i + 1][k];

                    if (compare(x, y) < 0)
                        ans[i][k] = x;
                    else
                        ans[i][k] = y;

                    dp[i][k] = take;
                }
            }
        }

        return ans[0][4];
    }

    static int[] add(int x, int[] a) {
        int[] res = new int[a == null ? 1 : a.length + 1];

        res[0] = x;

        if (a != null)
            for (int i = 0; i < a.length; i++)
                res[i + 1] = a[i];

        Arrays.sort(res);
        return res;
    }

    static int compare(int[] a, int[] b) {
        if (a == null) return 1;
        if (b == null) return -1;

        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            if (a[i] != b[i])
                return Integer.compare(a[i], b[i]);
        }

        return Integer.compare(a.length, b.length);
    }
}