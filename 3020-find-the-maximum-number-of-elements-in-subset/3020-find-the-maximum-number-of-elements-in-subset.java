class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put((long)x, map.getOrDefault((long)x, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            if (cnt % 2 == 0) cnt--;
            ans = Math.max(ans, cnt);
        }

        for (long x : map.keySet()) {

            if (x == 1) continue;

            long cur = x;
            int len = 0;

            while (map.containsKey(cur)) {

                int freq = map.get(cur);

                if (freq >= 2) {
                    len += 2;
                    if (cur > 1000000000L / cur) break;
                    cur *= cur;
                } else {
                    len++;
                    break;
                }
            }

            if (len % 2 == 0) len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}