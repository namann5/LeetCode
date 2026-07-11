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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSame(root.left ,root.right);
    }

    private boolean isSame(TreeNode r1, TreeNode r2){
        if(r1== null && r2 == null) return true;

        if(r1==null || r2==null){
            return false;
        }

        if(r1.val != r2.val) return false;

        boolean t1 = isSame(r1.left, r2.right);
        boolean t2 =isSame(r1.right, r2.left);

        return t1 && t2;
    }

    
}