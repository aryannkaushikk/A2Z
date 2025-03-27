// At each root value keep sending sum+root.val to left and right until a leaf node is reached then the sum at leaf is targetSum return true else false.
// return left || false 

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
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }

    public static boolean pathSum(TreeNode root, int targetSum, int sum){
        if(root==null){
            return false;
        }
        if(isLeaf(root)){
            if(sum+root.val==targetSum){
                return true;
            }
            return false;
        }
        sum += root.val;
        return pathSum(root.left,targetSum,sum) || pathSum(root.right,targetSum,sum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return pathSum(root,targetSum,sum);
    }
}
