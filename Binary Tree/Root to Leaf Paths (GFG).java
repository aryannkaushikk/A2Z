Simple PreOrder Traversal You add node to list then go left and right and then remove that node
Whenever a leaf node is encountered add it and add the list to nested list as new list

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
    
    public static boolean isLeaf(Node root){
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    
    public static void inOrder(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            list.add(root.data);
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.data);
        inOrder(root.left,list,ans);
        inOrder(root.right,list,ans);
        list.remove(list.size()-1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list, ans);
        return ans;
    }
}
