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

    private static int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = diameter(root.left);
        int r = diameter(root.right);
        
        maxx = Math.max(maxx,l+r+1);

        return 1+Math.max(l,r);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxx = Integer.MIN_VALUE;
        diameter(root);
        return maxx-1;
    }
}
