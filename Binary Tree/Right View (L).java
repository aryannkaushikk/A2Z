preOrder traversal if given list.size() = level then add
Root->Left->Right in LeftView
Root->Right->Left in RightView

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

    public static void preOrder(TreeNode root, int level, List<Integer> list){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.val);
        }
        preOrder(root.right,level+1,list);
        preOrder(root.left,level+1,list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preOrder(root,0,list);
        return list;
    }
}
