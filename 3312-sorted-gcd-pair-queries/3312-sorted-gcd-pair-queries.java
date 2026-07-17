class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] exact = new long[max + 1];

        // exact[d] = number of pairs having gcd exactly d
        for (int d = max; d >= 1; d--) {

            long cnt = 0;

            for (int j = d; j <= max; j += d) {
                cnt += freq[j];
            }

            exact[d] = cnt * (cnt - 1) / 2;

            for (int j = d * 2; j <= max; j += d) {
                exact[d] -= exact[j];
            }
        }

        // prefix[i] = number of pairs whose gcd <= i
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long k = queries[i] + 1;

            int l = 1, r = max;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}