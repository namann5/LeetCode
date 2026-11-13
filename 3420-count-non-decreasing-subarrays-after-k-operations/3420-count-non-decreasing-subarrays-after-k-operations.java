class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long ans = 0;
        long cost = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Merge smaller groups into current element
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.pollLast();

                count += last[1];

                cost += (long) (num - last[0]) * last[1];
            }

            dq.offerLast(new int[]{num, count});

            // Reduce window until cost becomes valid
            while (cost > k) {

                int[] first = dq.pollFirst();

                cost -= (long) first[0] - nums[j];

                j--;

                if (first[1] > 1) {
                    dq.offerFirst(new int[]{
                        first[0], first[1] - 1
                    });
                }
            }

            // Count valid subarrays ending at j
            ans += j - i + 1;
        }

        return ans;
    }
}
