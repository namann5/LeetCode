class Solution {
    public int minimumPushes(String word) {

        int n = word.length();
        int res = 0;
        int p = 1;

        while (n > 8) {
            res += 8 * p;
            n -= 8;
            p++;
        }

        res += n * p;

        return res;
    }
}