"""
Approach

Use Queue
"""

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int size = adj.size();
        int[] vis = new int[size];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(vis[curr]==1) continue;
            vis[curr] = 1;
            for(int x : adj.get(curr)){
                if(vis[x]==0) q.offer(x);
            }
            list.add(curr);
        }
        return list;
    }
}
