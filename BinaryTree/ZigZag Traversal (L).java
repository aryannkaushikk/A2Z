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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        boolean flag = true;
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while (!s1.isEmpty() && flag){
                TreeNode temp = s1.pop();
                list.add(temp.val);
                    if (temp.left != null) {
                        s2.push(temp.left);
                    }
                    if (temp.right != null) {
                        s2.push(temp.right);
                    }
            }
            while (!s2.isEmpty() && !flag){
                TreeNode temp = s2.pop();
                list.add(temp.val);
                if (temp.right != null) {
                    s1.push(temp.right);
                }
                if (temp.left != null) {
                    s1.push(temp.left);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
