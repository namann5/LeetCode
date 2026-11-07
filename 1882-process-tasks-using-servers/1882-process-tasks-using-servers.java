class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Available servers: weight, index
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );

        // Busy servers: freeTime, weight, index
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return a[2] - b[2];
            }
        );

        // Initially all servers are available
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        for (int i = 0; i < m; i++) {

            // Release servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= i) {
                int[] server = busy.poll();

                available.offer(new int[]{
                    server[1], server[2]
                });
            }

            if (!available.isEmpty()) {

                int[] server = available.poll();

                int weight = server[0];
                int index = server[1];

                ans[i] = index;

                busy.offer(new int[]{
                    i + tasks[i], weight, index
                });

            } else {

                // Wait for the earliest server to become free
                int[] server = busy.poll();

                int freeTime = server[0];
                int weight = server[1];
                int index = server[2];

                ans[i] = index;

                busy.offer(new int[]{
                    freeTime + tasks[i], weight, index
                });
            }
        }

        return ans;
    }
}
