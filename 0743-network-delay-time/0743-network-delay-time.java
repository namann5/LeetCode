class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int s = times[i][0];
            int d = times[i][1];
            int wt = times[i][2];

            adj.get(s-1).add(new int[]{d-1,wt});
         //   adj.get(d-1).add(new int[]{s,wt});

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k-1]=0;
        pq.offer(new int[]{0,k-1});

        while(!pq.isEmpty()){
            int[] p = pq.poll();

            int d = p[0];
            int node = p[1];

            if(d > dis[node]){
                continue;
            }

            for(int j=0;j<adj.get(node).size();j++){
                int neighbour = adj.get(node).get(j)[0];
                int wt = adj.get(node).get(j)[1];

                if(d + wt < dis[neighbour]){
                    dis[neighbour]= wt+d;
                    pq.offer(new int[]{dis[neighbour], neighbour});
                }
            }

        }
        int ans = 0;

        for (int d : dis) {
        if (d == Integer.MAX_VALUE) {
        return -1;
        }
        ans = Math.max(ans, d);
        }

        return ans;
    }
}