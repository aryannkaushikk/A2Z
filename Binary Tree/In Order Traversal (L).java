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

    private static List<Integer> list;

    private static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        if(root==null){
            return list;
        }
        inOrder(root);
        return list;
    }
}
