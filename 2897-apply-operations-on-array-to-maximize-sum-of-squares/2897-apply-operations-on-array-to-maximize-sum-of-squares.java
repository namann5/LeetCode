class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = 1_000_000_007;
        int[] count = new int[31];

        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    count[bit]++;
                }
            }
        }

        long ans = 0;

        while (k-- > 0) {
            long num = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (count[bit] > 0) {
                    num |= (1L << bit);
                    count[bit]--;
                }
            }

            ans = (ans + num * num) % mod;
        }

        return (int) ans;
    }
}