class Solution {

    List<Integer>[] graph;
    boolean[] vis;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                List<Integer> comp = new ArrayList<>();
                dfs(i, comp);

                boolean complete = true;

                for (int x = 0; x < comp.size() && complete; x++) {

                    for (int y = x + 1; y < comp.size(); y++) {

                        if (!graph[comp.get(x)].contains(comp.get(y))) {
                            complete = false;
                            break;
                        }
                    }
                }

                if (complete)
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int node, List<Integer> comp) {

        vis[node] = true;
        comp.add(node);

        for (int nei : graph[node]) {
            if (!vis[nei])
                dfs(nei, comp);
        }
    }
}