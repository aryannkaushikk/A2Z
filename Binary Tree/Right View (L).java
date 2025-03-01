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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        list.add(root.val);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp==null){
                if(q.isEmpty()){
                    break;
                }
                list.add(q.peek().val);
                q.offer(null);
                continue;
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }
            if(temp.left!=null){
                q.offer(temp.left);
            }
        }
        return list;
    }
}
