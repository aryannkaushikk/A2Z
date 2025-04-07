"""Keep Adding each number to sum and pass it to left and right if current node is leaf add it and add to sum"""

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

    public static boolean isLeaf(TreeNode root){
        return root==null || (root.left==null && root.right==null);
    }

    public void summer(TreeNode root, int curr_sum, int[] sum){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            sum[0] += (10*curr_sum)+root.val;
            return;
        }
        summer(root.left, (10*curr_sum)+root.val, sum);
        summer(root.right, (10*curr_sum)+root.val, sum);
    }

    public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        summer(root, 0,sum);
        return sum[0];
    }
}
