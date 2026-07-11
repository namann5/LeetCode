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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(isSame(root, subRoot)) return true;

        boolean r1 = isSubtree(root.left, subRoot);
        boolean r2 = isSubtree(root.right, subRoot);

        return r1 || r2;
    }
    boolean isSame(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p ==null || q == null) return false;

        if(p.val != q.val) return false;

        boolean r1 = isSame(p.left, q.left);
        boolean r2 = isSame(p.right, q.right);

        return r1 && r2;

    }
}