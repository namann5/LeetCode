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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List <List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue <TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        boolean LtR = true;

        while(!q.isEmpty()){
            int size = q.size();

            LinkedList <Integer> temp = new LinkedList<>();

            while(size-- > 0){
                TreeNode node = q.poll();

                if(LtR){
                    temp.addLast(node.val);
                }else {
                    temp.addFirst(node.val);
                }

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }
            }

            res.add(temp);
            LtR = !LtR;
        }
        return res;
    }
}