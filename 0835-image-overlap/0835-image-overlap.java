class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int n = a.length, ans = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(a[i][j] == 1)
                    for(int x=0;x<n;x++)
                        for(int y=0;y<n;y++)
                            if(b[x][y] == 1) {
                                String key = (x-i) + "," + (y-j);
                                map.put(key, map.getOrDefault(key, 0) + 1);
                                ans = Math.max(ans, map.get(key));
                            }

        return ans;
    }
}