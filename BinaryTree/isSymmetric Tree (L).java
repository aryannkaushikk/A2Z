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

    private static boolean symmetry(TreeNode left, TreeNode right){
        if(left==null || right==null){
            return left==right;
        }
        return left.val==right.val && symmetry(left.left,right.right) && symmetry(left.right,right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root==null || symmetry(root.left,root.right);
    }
}
