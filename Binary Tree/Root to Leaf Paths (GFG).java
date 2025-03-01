/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private static ArrayList<ArrayList<Integer>> res;
    
    private static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    
    private static void rootToNode(Node root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            list.add(root.data);
            res.add(list);
            return;
        }
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.addAll(list);
        l2.addAll(list);
        l1.add(root.data);
        l2.add(root.data);
        rootToNode(root.left,l1);
        rootToNode(root.right,l2);
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        if(root==null){
            return null;
        }
        res = new ArrayList<>();
        rootToNode(root,new ArrayList<>());
        return res;
    }
}
