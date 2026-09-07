class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1000000007;

        long[] last = new long[26];

        long dp = 1; // empty subsequence

        for (char ch : s.toCharArray()) {

            int index = ch - 'a';

            long newDp = (2 * dp - last[index] + MOD) % MOD;

            last[index] = dp;

            dp = newDp;
        }

       // empty seq ko remove krenge 
        return (int)((dp - 1 + MOD) % MOD);
    }
}