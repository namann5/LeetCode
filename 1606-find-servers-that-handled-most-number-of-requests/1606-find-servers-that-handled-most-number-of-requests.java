class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int[] count = new int[k];

        // Available servers
        TreeSet<Integer> free = new TreeSet<>();

        // Busy servers: {finishTime, serverIndex}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            int time = arrival[i];

            // Release servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                free.add(server[1]);
            }

            // All servers are busy
            if (free.isEmpty()) {
                continue;
            }

            // Find next available server
            int preferred = i % k;

            Integer server = free.ceiling(preferred);

            // Wrap around
            if (server == null) {
                server = free.first();
            }

            free.remove(server);

            count[server]++;

            // Mark server busy
            busy.offer(new int[]{
                time + load[i], server
            });
        }

        // Find maximum requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
