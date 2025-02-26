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
    
    private static HashMap<Node, Node> parentMapping(Node root){
        if(root==null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        map.put(root,null);

        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left!=null){
                q.offer(temp.left);
                map.put(temp.left,temp);
            }
            if(temp.right!=null){
                q.offer(temp.right);
                map.put(temp.right,temp);
            }
        }
        return map;
    }

    public static int minTime(Node root, int target) {
        if(root==null){
            return -1;
        }
        Queue<Node> q = new LinkedList<>();
        HashSet<Integer> v = new HashSet<>();
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> tq = new LinkedList<>();
        tq.offer(root);
        map.put(root,null);
        
        while(!tq.isEmpty()){
            Node temp = tq.poll();
            if(temp.data==target){
                q.offer(temp);
                v.add(target);
            }
            if(temp.left!=null){
                tq.offer(temp.left);
                map.put(temp.left,temp);
            }
            if(temp.right!=null){
                tq.offer(temp.right);
                map.put(temp.right,temp);
            }
        }

        
        int count = 0;
        boolean flag;
        while (!q.isEmpty()){
            int size = q.size();
            flag = false;
            while (size!=0){
                Node temp = q.poll();
                Node parent = map.get(temp);
                if(parent!=null && !v.contains(parent.data)){
                    v.add(parent.data);
                    q.offer(parent);
                    flag = true;
                }
                if(temp.left!=null && !v.contains(temp.left.data)){
                    v.add(temp.left.data);
                    q.offer(temp.left);
                    flag = true;
                }
                if(temp.right!=null && !v.contains(temp.right.data)){
                    v.add(temp.right.data);
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
