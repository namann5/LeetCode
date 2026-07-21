class Solution {
    int[] x = {-1,1,0,0};
    int[] y= {0,0,-1,1};
    public void solve(char[][] board) {
       int n =  board.length;
       int m = board[0].length;
       int i,j=0;

       for(j=0;j<m;j++){
        if(board[0][j]== 'O'){
            dfs(board,n,m,0,j);
        }
       } 
       for(j=0;j<m;j++){
        if(board[n-1][j]=='O'){
            dfs(board,n,m,n-1,j);
        }
       }

       for(i=0;i<n;i++){
        if(board[i][0]== 'O'){
            dfs(board,n,m,i,0);
        }
       }
        for(i=0;i<n;i++){
            if(board[i][m-1]=='O'){
                dfs(board,n,m,i,m-1);
            }
        }

        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else {
                    board[i][j]= 'X';
                }
            }
        }
        return;
    }

    boolean valid(int i,int j , int n, int m){
        if(i <0 || i >= n || j <0 || j >= m){
            return false;
        }
        return true;
    }

    void dfs(char[][] board , int n, int m , int i ,int j){
        board[i][j] = '#';

        for( int k =0; k < 4; k++){
            int row = i + x[k];
            int col = j + y[k];

            if(valid(row,col,n,m) && board[row][col] == 'O'){
                dfs(board,n,m,row,col);
            }
        }
        return;
    }

}