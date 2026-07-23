class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] res = new int[n][m];

        for(int i =0;i<n;i++){
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b) -> a[0]-b[0]);

        res[0][0] = 0;
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] p = pq.poll();

            int effort = p[0];
            int row = p[1];
            int col = p[2];

            if(effort > res[row][col]){ // outdated
                continue;
            }

            for(int k=0;k<4;k++){
                int r = row + x[k];
                int c = col + y[k];

                if(!valid(r,c,n,m)){
                    continue;
                }

                int absD = Math.abs(heights[row][col] - heights[r][c]);
                int newWt = Math.max(absD, effort);

                if(newWt < res[r][c]){
                    res[r][c] = newWt;
                    pq.offer(new int[]{newWt, r,c});
                }
            }
        }
        return res[n-1][m-1];
    }

    boolean valid(int i, int j, int n , int m){
        if(i<0 || i>= n || j<0 || j >= m){
            return false;
        }
        return true;
    }
}