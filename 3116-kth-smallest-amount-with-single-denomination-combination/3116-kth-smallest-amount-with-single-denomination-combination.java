class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long low = 1;
        long high = (long) coins[0] * k;

        // Binary search range
        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Count numbers <= x divisible by at least one coin
    private long count(long x, int[] coins) {
        int n = coins.length;
        long total = 0;

        // Inclusion-Exclusion
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    // No multiples <= x possible
                    if (lcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                long cnt = x / lcm;

                if (bits % 2 == 1) {
                    total += cnt;
                } else {
                    total -= cnt;
                }
            }
        }

        return total;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}