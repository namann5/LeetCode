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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List <List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue <TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int lvl = q.size();

                 List<Integer> temp = new ArrayList<>();

            while(lvl-- > 0){
                TreeNode t = q.peek();
                q.poll();

                temp.add(t.val);

                if(t.left != null){
                    q.offer(t.left);
                }

                if(t.right != null){
                    q.offer(t.right);
                }
            }

            res.add(temp);
        }
        return res;
    }
}