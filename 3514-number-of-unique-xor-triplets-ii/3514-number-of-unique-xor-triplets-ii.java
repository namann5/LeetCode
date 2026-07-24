class Solution {
    public int uniqueXorTriplets(int[] nums) {

        boolean[] one = new boolean[2048];
        boolean[] two = new boolean[2048];
        boolean[] three = new boolean[2048];

        for (int x : nums) {
            one[x] = true;
        }

        for (int i = 0; i < 2048; i++) {
            if (!one[i]) continue;
            for (int x : nums) {
                two[i ^ x] = true;
            }
        }

        for (int i = 0; i < 2048; i++) {
            if (!two[i]) continue;
            for (int x : nums) {
                three[i ^ x] = true;
            }
        }

        int ans = 0;
        for (boolean b : three) {
            if (b) ans++;
        }

        return ans;
    }
}