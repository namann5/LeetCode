import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxEdge = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new int[]{v, w});
            indegree[v]++;
            maxEdge = Math.max(maxEdge, w);
        }

        // Topological order
        int[] topo = new int[n];
        int idx = 0;

        Queue<Integer> q = new LinkedList<>();
        int[] deg = indegree.clone();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                if (--deg[v] == 0) {
                    q.offer(v);
                }
            }
        }

        int low = 0;
        int high = maxEdge;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(mid, graph, topo, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int minEdge,
                             List<int[]>[] graph,
                             int[] topo,
                             boolean[] online,
                             long k,
                             int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF) continue;

            if (u != 0 && u != n - 1 && !online[u]) continue;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int w = edge[1];

                if (w < minEdge) continue;

                if (v != n - 1 && !online[v]) continue;

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}