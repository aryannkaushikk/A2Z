"""
Approach

Simple Root to Path Question
Using StringBuilder as it is more time consuming to use String in Java
First maintain a current Length of SB
Then after operations delete anything added after current Length before returning
"""

class Solution {

    boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }

    void preOrder(TreeNode root, StringBuilder s, List<String> list){
        if(root==null) return;
        int currLen = s.length();
        s.append(root.val);
        if(isLeaf(root)){
            list.add(s.toString());
        }else{
            s.append("->");
            preOrder(root.left, s, list);
            preOrder(root.right, s, list);
        }
        s.delete(currLen, s.length());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        preOrder(root, new StringBuilder(), list);
        return list;
    }
}
