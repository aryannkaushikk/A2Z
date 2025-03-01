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

    public static int getHeightLeft(TreeNode left){
        if(left==null){
            return 0;
        }
        TreeNode temp = left;
        int i = 1;
        while(temp.left!=null){
            temp = temp.left;
            i++;
        }
        return i;
    }

    public static int getHeightRight(TreeNode right){
        if(right==null){
            return 0;
        }
        TreeNode temp = right;
        int i = 1;
        while(temp.right!=null){
            temp = temp.right;
            i++;
        }
        return i;
    }

    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = getHeightLeft(root.left);
        int r = getHeightRight(root.right);

        if(l==0 && r==0){
            return 1;
        }

        if(l==r){
            return (int) (Math.pow(2,l+1))-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
