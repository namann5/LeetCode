class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0)
                pq.offer(f);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {

            time++;

            if (!pq.isEmpty()) {

                int cnt = pq.poll() - 1;

                if (cnt > 0) {
                    q.offer(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.offer(q.poll()[0]);
            }
        }

        return time;
    }
}