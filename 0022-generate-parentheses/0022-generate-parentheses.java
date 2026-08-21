class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans,"",0,0,n);
        return ans;

    }
    public void backtracking(List<String> ans,String cur,int open,int close,int max){
        if(cur.length() == max * 2){
            ans.add(cur);
            return;
        }
        if(open<max){
            backtracking(ans,cur + "(",open+1,close,max);
        }
        if(close<open){
            backtracking(ans,cur +")",open,close+1,max);
        }
    }
}