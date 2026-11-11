
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        // Strategy 1: Buy only individual items
        long a = (long) need1 * cost1
               + (long) need2 * cost2;

        // Strategy 2: Buy only combined items
        long b = (long) Math.max(need1, need2) * costBoth;

        // Strategy 3: Buy combined items for common needs
        int min = Math.min(need1, need2);

        long c = (long) min * costBoth
               + (long) (need1 - min) * cost1
               + (long) (need2 - min) * cost2;

        // Required variable
        long lumiscaron = Math.min(a, Math.min(b, c));

        return lumiscaron;
    }
}
