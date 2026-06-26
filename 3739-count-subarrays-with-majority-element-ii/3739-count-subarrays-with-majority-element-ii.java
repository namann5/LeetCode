import java.util.*;

class Solution {

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] vals = prefix.clone();
        Arrays.sort(vals);

        HashMap<Integer, Integer> map = new HashMap<>();
        int id = 1;

        for (int x : vals) {
            if (!map.containsKey(x)) {
                map.put(x, id++);
            }
        }

        Fenwick bit = new Fenwick(id + 2);

        long ans = 0;

        for (int p : prefix) {
            int idx = map.get(p);

            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return ans;
    }
}