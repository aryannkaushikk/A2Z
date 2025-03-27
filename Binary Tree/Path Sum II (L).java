// Same as Path Sum, just keep storing the path in a list and remove last element when it returns from its both left and right.
// Store in nested list as as new list.

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

    public static void pathSumFinder(TreeNode root, int targetSum, int sum, List<Integer> list, List<List<Integer>> ans){
        if(root==null){
            return;
        }
        sum += root.val;
        list.add(root.val);
        if(sum == targetSum && isLeaf(root)){
            ans.add(new LinkedList<>(list));
            list.removeLast();
            return;
        }
        pathSumFinder(root.left,targetSum,sum,list,ans);
        pathSumFinder(root.right,targetSum,sum,list,ans);
        list.removeLast();
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>(); 
        pathSumFinder(root,targetSum,0,list,ans);
        return ans;
    }
}
