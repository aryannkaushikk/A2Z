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

    private static int maxPathSumFinder(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = maxPathSumFinder(root.left);
        int r = maxPathSumFinder(root.right);
        maxx = Math.max(maxx,l+r+root.val);
        maxx = Math.max(maxx,r+root.val);
        maxx = Math.max(maxx,l+root.val);
        maxx = Math.max(maxx,root.val);
        int all = root.val+Math.max(l,r);
        if(root.val>all){
            return root.val;
        }
        return all;
    }

    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxx = Integer.MIN_VALUE;
        maxPathSumFinder(root);
        return maxx;
    }
}
