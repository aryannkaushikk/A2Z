Firstly we are using level order for parent mapping and at the same time finding target node
Then we traverse radially outward from the target
If any or all element from q burns a element i.e adds to queue then it counts as 1

class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/
    
    private static Node parentMappingAndTargetFind(Node root, HashMap<Node,Node> map, int target){
        if(root==null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        map.put(root,null);
        Node t = null;
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.data==target){
                t = temp;
            }
            if(temp.left!=null){
                q.offer(temp.left);
                map.put(temp.left,temp);
            }
            if(temp.right!=null){
                q.offer(temp.right);
                map.put(temp.right,temp);
            }
        }
        return t;
    }

    public static int minTime(Node root, int target) {
        if(root==null){
            return -1;
        }
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> v = new HashSet<>();
        HashMap<Node, Node> map = new HashMap<>();
        Node t = parentMappingAndTargetFind(root,map,target);
        v.add(t);
        q.add(t);
        int count = 0;
        boolean flag;
        while (!q.isEmpty()){
            int size = q.size();
            flag = false;
            while (size!=0){
                Node temp = q.poll();
                Node parent = map.get(temp);
                if(parent!=null && !v.contains(parent)){
                    v.add(parent);
                    q.offer(parent);
                    flag = true;
                }
                if(temp.left!=null && !v.contains(temp.left)){
                    v.add(temp.left);
                    q.offer(temp.left);
                    flag = true;
                }
                if(temp.right!=null && !v.contains(temp.right)){
                    v.add(temp.right);
                    q.offer(temp.right);
                    flag = true;
                }
                size--;
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}
