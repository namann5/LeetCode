class Solution {
    public long countCommas(long n) {
        long ans = 0;

        ans += Math.max(n - 999L, 0L);
        ans += Math.max(n - 999999L, 0L);
        ans += Math.max(n - 999999999L, 0L);
        ans += Math.max(n - 999999999999L, 0L);
        ans += Math.max(n - 999999999999999L, 0L);

        return ans;
    }
}