class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        int idx =0;
        int sum=0;

        List<Integer> dairy = new ArrayList<>();

        backtrack(candidates, n, idx, dairy, sum , res, target);
        return res;


    }

    void backtrack(int[] candidates, int n, int idx , List<Integer> dairy, int sum , List<List<Integer>> res, int target){
        if(idx == n){
            if(sum == target){
                res.add(new ArrayList<>(dairy));
               
            }
             return;
        }

        backtrack(candidates, n, idx+1, dairy, sum , res, target);
         
         if(candidates[idx] + sum <= target){
            dairy.add(candidates[idx]);
            sum = sum + candidates[idx];

            backtrack(candidates, n,idx,dairy,sum, res, target);
            dairy.remove(dairy.size() - 1);
            sum = sum - candidates[idx];
         }
    }
}