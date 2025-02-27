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

    private static int maxx;

    private static int maxH(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = maxH(root.left);
        int r = maxH(root.right);

        maxx = Math.max(maxx,l+1);
        maxx = Math.max(maxx,r+1);

        return 1+Math.max(l,r);
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxx = Integer.MIN_VALUE;
        maxH(root);
        return maxx;
    }
}
