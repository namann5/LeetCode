class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] cnt = new int[3];

        for (int x : stones) {
            cnt[x % 3]++;
        }

        // If there are no remainder-1 or remainder-2 stones,
        // Alice cannot make a winning move.
        if (cnt[1] == 0 && cnt[2] == 0) {
            return false;
        }

        // If cnt[0] is even, the game effectively depends on
        // whether Alice can force the opponent into a bad state.
        if (cnt[0] % 2 == 0) {
            return cnt[1] >= 1 && cnt[2] >= 1;
        }

        // cnt[0] is odd
        return Math.abs(cnt[1] - cnt[2]) > 2;
    }
}