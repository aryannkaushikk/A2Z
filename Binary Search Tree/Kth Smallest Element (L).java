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

    private static int val;
    private static int count;

    public static void inOrder(TreeNode root, int k){
        if(root==null){
            return;
        }
        inOrder(root.left,k);
        count++;
        if(count==k){
            val = root.val;
            return;
        }
        inOrder(root.right,k);
    }


    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        val = 0;
        count = 0;
        inOrder(root,k);
        return val;
    }
}
