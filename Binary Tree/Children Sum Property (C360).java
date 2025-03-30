If root.val>l+r put l=r=root.val then call func for l and r after that in end put root.val = l+r to ensure any changes cause to them
If root.val<l+r simply put root.val = l+r

import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {

    public static int getValue(BinaryTreeNode <Integer> root){
        if(root==null){
            return 0;
        }
        return root.data;
    }

    public static boolean isLeaf(BinaryTreeNode <Integer> root){
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }

    public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root==null || isLeaf(root)){
            return;
        }
        int l = getValue(root.left);
        int r = getValue(root.right);

        if(l+r>root.data){
            root.data = l+r;
        }else if(l+r<root.data){
            if(root.left!=null){
                root.left.data = root.data;
            }
            if(root.right!=null){
                root.right.data = root.data;
            }
        }
        changeTree(root.left);
        changeTree(root.right);
        root.data = getValue(root.left)+getValue(root.right);
    }
}
