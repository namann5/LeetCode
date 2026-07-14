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
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> dairy = new ArrayList<>();
        fun(root,0,targetSum,dairy,res);
        return res;

    }

    private void fun(TreeNode root, int sum ,int targetSum, List<Integer> dairy, List<List<Integer>>res){
        if(root == null){
            return; 
        }

        
        sum = sum + root.val;
        dairy.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == targetSum){
                res.add(new ArrayList<>(dairy));
                dairy.remove(dairy.size() -1);
                return;
            }
        }

        fun(root.left,sum,targetSum,dairy,res);
        fun(root.right,sum,targetSum,dairy,res);
        dairy.remove(dairy.size()-1);
        return;
    }
}