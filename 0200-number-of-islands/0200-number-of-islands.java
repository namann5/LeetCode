class Solution {
    int x[] = {-1,1,0,0};
    int y[] = {0,0,-1,1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int res =0;

        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j <m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,n,m,i,j,visited);
                    res++;
                }
            }
        }
        return res;
    }

    boolean valid(int i,int j ,int n , int m){
        if(i<0 || i >= n || j <0 || j >= m){
            return false;
        }else {
            return true;
        }
    }

    void dfs(char[][] grid, int n, int m , int i ,int j, boolean[][] visited){
        visited[i][j] = true;
        for(int k=0;k < 4;k++){
            int row = i + x[k];
            int col = j + y[k];

            if(valid(row,col,n,m) && grid[row][col]== '1' && !visited[row][col]){
                dfs(grid,n,m,row,col,visited);
            }
        }
        return;
    }

}