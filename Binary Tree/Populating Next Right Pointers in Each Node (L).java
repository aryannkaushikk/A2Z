Approach 2 (Optimal)

Connect the left and right of root if not null
Then in recursion for each pair of left and right
connect left.left to left.right and right.left to right.right
then for right.right.next will be the left.left of next left-right pair in same level you can access that left using the right.next if it is not null
then call the same func for left.left,left.right and right.left, right.right

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public static boolean isLeaf(Node root){
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }

    public static void rec(Node left, Node right){
        if(isLeaf(left)){
            return;
        }
        left.left.next = left.right;
        right.left.next = right.right;
        left.right.next = right.left;
        if(right.next!=null){
            right.right.next = right.next.left;
        }
        rec(left.left,left.right);
        rec(right.left,right.right);
    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        if(left!=null){
            left.next = right;
            rec(left,right);
        }
        return root;
    }
}


Approach 1 (Brute)

Level order traversal and mark each next node as curr.next
Maintaining a size var so that newly added next level nodes dont get used

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node curr = q.poll();
            while(size>0){
                Node temp = null;
                if(size-1>0){
                    temp = q.poll();
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
                curr.next = temp;
                curr = curr.next;
                size--;
            }
        }
    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        bfs(root);
        return root;
    }
}
