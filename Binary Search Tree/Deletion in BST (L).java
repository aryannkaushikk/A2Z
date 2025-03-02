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

    public static TreeNode insert(TreeNode root, TreeNode key){
        if(key==null){
            return root;
        }
        if(root==null){
            return key;
        }
        if(root.val>key.val){
            root.left = insert(root.left,key);
        }else{
            root.right = insert(root.right,key);
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            if(root.right!=null){
                TreeNode l = root.left;
                root = root.right;
                root.left = insert(root.left,l);
            }else if(root.left!=null){
                TreeNode r = root.right;
                root = root.left;
                root.right = insert(root.right,r);
            }else{
                return null;
            }
        }else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
