import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[] parent, depth, tin, tout, bit;
    int[][] up;
    int timer, LOG;
    Fenwick fw;

    class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            for (i++; i < tree.length; i += i & -i) {
                tree[i] ^= val;
            }
        }

        int query(int i) {
            int ans = 0;
            for (; i > 0; i -= i & -i) {
                ans ^= tree[i];
            }
            return ans;
        }
    }

    public List<Boolean> palindromePath(
        int n, int[][] edges, String s, String[] queries
    ) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        timer = 0;

        dfs(0, -1);

        LOG = 32 - Integer.numberOfLeadingZeros(n);
        up = new int[LOG][n];
        up[0] = parent.clone();

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }

        bit = new int[n];
        for (int i = 0; i < n; i++) {
            bit[i] = 1 << (s.charAt(i) - 'a');
        }

        fw = new Fenwick(n + 1);

        for (int i = 0; i < n; i++) {
            fw.update(tin[i], bit[i]);
            fw.update(tout[i], bit[i]);
        }

        // Required by the problem statement
        String[] suneravilo = queries;

        List<Boolean> ans = new ArrayList<>();

        for (String q : suneravilo) {
            String[] p = q.split(" ");
            int u = Integer.parseInt(p[1]);

            if (p[0].equals("update")) {
                int newBit = 1 << (p[2].charAt(0) - 'a');

                if (bit[u] != newBit) {
                    int diff = bit[u] ^ newBit;

                    fw.update(tin[u], diff);
                    fw.update(tout[u], diff);

                    bit[u] = newBit;
                }
            } else {
                int v = Integer.parseInt(p[2]);
                int w = lca(u, v);

                int mask = fw.query(tin[u] + 1)
                         ^ fw.query(tin[v] + 1)
                         ^ bit[w];

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    void dfs(int u, int p) {
        parent[u] = (p == -1) ? 0 : p;
        tin[u] = timer++;

        for (int v : graph[u]) {
            if (v != p) {
                depth[v] = depth[u] + 1;
                dfs(v, u);
            }
        }

        tout[u] = timer;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if (((diff >> j) & 1) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return parent[u];
    }
}