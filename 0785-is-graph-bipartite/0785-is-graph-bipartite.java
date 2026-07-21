class Solution {
    boolean res=  true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] colours = new int[n];
         Arrays.fill(colours, -1);
        for(int i=0;i<n;i++){
            if(colours[i]==-1){
                dfs(graph,i,0,colours);
            }
        }
        return res;
    }

    void dfs(int[][] graph , int node, int c , int[] colours){
        colours[node] = c;

        for(int j=0;j<graph[node].length;j++){
            int neighbour = graph[node][j];

            if(colours[neighbour]==c){
                res = false;
                return;
            }
            if(colours[neighbour]==-1){
                dfs(graph,neighbour,1-c,colours);
            }
        }
        return;
    }
}