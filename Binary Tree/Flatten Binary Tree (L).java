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

    private static TreeNode curr;

    private static void flat(TreeNode root){
        if(root==null){
            return;
        }
        curr = root;
        TreeNode temp = root.right;

        curr.right = curr.left;
        curr.left = null;
        flat(curr.right);
        curr.right = temp;
        flat(curr.right);
    }

    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        curr = null;
        flat(root);
    }
}
