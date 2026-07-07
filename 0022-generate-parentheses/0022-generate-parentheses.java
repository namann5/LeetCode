class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> res =  new ArrayList<>();

        int open =0;
        int close =0;

        StringBuilder sb = new StringBuilder();

            fun(res,sb,open,close,n);
            return res;

    }

    private void fun(List<String> res , StringBuilder sb , int open, int close , int n){

        if(open == n && close == n){
            res.add(sb.toString());
            return;
        }

        // open
        if(open < n){
            sb.append('(');
            fun(res,sb,open+1,close,n);
            sb.deleteCharAt(sb.length() -1);
        }

        //close 
        if(close < open){
            sb.append(')');
            fun(res,sb,open,close +1,n);
            sb.deleteCharAt(sb.length() -1);
        }

    }
}