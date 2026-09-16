class Solution {
    public int numberOfSets(int n, int k) {
        long ans = 1;
        long MOD = 1000000007;

        int a = n + k - 1;
        int b = 2 * k;

        for (int i = 1; i <= b; i++) {
            ans = ans * (a - i + 1) % MOD;

            ans = ans * modInverse(i, MOD) % MOD;
        }

        return (int) ans;
    }

    long modInverse(long x, long MOD) {
        return power(x, MOD - 2, MOD);
    }

    long power(long x, long n, long MOD) {
        long ans = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * x % MOD;
            }

            x = x * x % MOD;
            n /= 2;
        }

        return ans;
    }
}