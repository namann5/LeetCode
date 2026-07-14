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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

          Stack<TreeNode> asc = new Stack<>();
         Stack<TreeNode> dsc = new Stack<>();


        TreeNode t = root;
        while(t != null){
            asc.push(t);
            t = t.left;
        }

       t= root;
        while(t!= null){
            dsc.push(t);
            t = t.right;
        }

        TreeNode i = getSmall(root,asc);
        TreeNode j = getBig(root,dsc);

        while(i != null && j != null && i != j && i.val <= j.val ){
            int sum = i.val + j.val;
            if(sum == k) return true;

            if(sum > k){
                j= getBig(root,dsc);
            }else {
                i= getSmall(root,asc);
            }
        }
        return false;




    }
    TreeNode getSmall(TreeNode root, Stack<TreeNode> asc){
        if(asc.isEmpty()){
            return null;
        }

        TreeNode small = asc.peek();
        asc.pop();

        TreeNode rightChild = small.right;
        while(rightChild != null){
            asc.push(rightChild);
            rightChild = rightChild.left;
        }
        return small;
    }

    TreeNode getBig(TreeNode root, Stack<TreeNode> dsc){
        if(dsc.isEmpty()) return null;

        TreeNode big = dsc.peek();
        dsc.pop();

        TreeNode leftChild = big.left;
        while(leftChild != null){
            dsc.push(leftChild);
            leftChild = leftChild.right;
        }
        return big;
    }

}