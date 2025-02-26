/*
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    
    private static int getVal(Node root){
        if(root==null){
            return 0;
        }
        return root.data;
    }
    
    public static int isSumProperty(Node root)
    {
        if(root==null){
            return 1;
        }
        int l = getVal(root.left);
        int r = getVal(root.right);
        int res = 0;
        
        if(l==0 && r==0){
            return 1;
        }
        
        if(l+r==root.data){
            res = 1;
        }
        return res & isSumProperty(root.left) & isSumProperty(root.right);
        
    }
}
