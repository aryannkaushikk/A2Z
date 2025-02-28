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

    public static Map<Integer,Integer> rootMap(int[] inorder){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return map;
    }

    public static TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numsRight = inEnd-inRoot;

        root.left = buildTree(postorder, postStart, postEnd-numsRight-1, inorder, inStart, inRoot-1, map);
        root.right = buildTree(postorder, postEnd-numsRight, postEnd-1, inorder, inRoot+1, inEnd, map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = rootMap(inorder);
        TreeNode root = buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
}
