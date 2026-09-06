/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List <List<Integer>> res = new ArrayList<>();
        dfs(root,targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int remain, List<Integer> dairy, List<List<Integer>>res){
        if(root == null) return;
        dairy.add(root.val);

        if(root.left == null && root.right == null && remain == root.val){
            res.add(new ArrayList<>(dairy));
        }else {
            dfs(root.left, remain - root.val, dairy, res);
            dfs(root.right, remain - root.val, dairy, res);
        }
        dairy.remove(dairy.size() -1);
    }
}