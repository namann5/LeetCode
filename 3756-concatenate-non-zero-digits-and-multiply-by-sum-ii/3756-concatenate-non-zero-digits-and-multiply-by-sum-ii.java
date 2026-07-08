class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        // Store non-zero digits and their positions
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                pos.add(i);
            }
        }

        int m = digits.size();

        long[] prefixSum = new long[m + 1];
        long[] prefixNum = new long[m + 1];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            prefixSum[i + 1] = prefixSum[i] + digits.get(i);
            prefixNum[i + 1] = (prefixNum[i] * 10 + digits.get(i)) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            long sum = prefixSum[right + 1] - prefixSum[left];

            int len = right - left + 1;

            long num = (prefixNum[right + 1]
                    - (prefixNum[left] * pow10[len]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((num * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr.get(mid) > target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}