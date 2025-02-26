/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private static HashMap<TreeNode, TreeNode> parentMapping(TreeNode root) {
        if (root == null) {
            return null;
        }
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root, null);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null) {
                q.offer(temp.left);
                map.put(temp.left, temp);
            }
            if (temp.right != null) {
                q.offer(temp.right);
                map.put(temp.right, temp);
            }
        }
        return map;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null){
            return null;
        }
        HashMap<TreeNode, TreeNode> map = parentMapping(root);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> v = new HashSet<>();
        q.offer(target);
        v.add(target);
        for (int i = 0; i < k; i++) {
            int size = q.size();
            while (size!=0){
                TreeNode temp = q.poll();
                TreeNode parent = map.get(temp);
                if(parent!=null && !v.contains(parent)){
                    v.add(parent);
                    q.offer(parent);
                }
                if(temp.left!=null && !v.contains(temp.left)){
                    v.add(temp.left);
                    q.offer(temp.left);
                }
                if(temp.right!=null && !v.contains(temp.right)){
                    v.add(temp.right);
                    q.offer(temp.right);
                }
                size--;
            }
        }
        List<Integer> list = q
        while (!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }
}
