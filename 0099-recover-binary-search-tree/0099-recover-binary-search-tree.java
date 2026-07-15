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
    TreeNode prev = null;
    TreeNode  g1First = null;
    TreeNode g1Second = null;
    TreeNode  g2First = null;
    TreeNode  g2Second = null;
    int galat =0; 
    public void recoverTree(TreeNode root) {
        fun(root);
        if(galat == 1){
            swap(g1First , g1Second);
        }else if(galat == 2) {
            swap(g1First, g2Second);
        }
    }

    void fun(TreeNode root){
        if(root == null) 
         return;

        fun(root.left);
        if(prev == null){
            prev = root;
        }else {
            if(root.val <= prev.val){
                if(galat ==0){
                    g1First = prev;
                    g1Second = root;
                    galat++;
                }
                else {
                    g2First = prev;
                    g2Second = root;
                    galat++;
                }
            }
            prev = root;
           
        }
         fun(root.right);
    }
    void swap(TreeNode a, TreeNode b) {
    int temp = a.val;
    a.val = b.val;
    b.val = temp;
    }
}