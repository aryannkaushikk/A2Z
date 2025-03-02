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

    private static long temp;
    private static boolean flag;
    
    public static void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(temp>=root.val){
            flag = false;
            return;
        }
        temp = root.val;
        inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        temp = Integer.MIN_VALUE;
        temp-=1;
        flag = true;
        inorder(root);
        return flag;
    }
}
