"""
Approach

We use Kahn's Algorithm

Concept is we use a count variable to count every time a node is popped from a queue
If there is a cycle the count will be less than V as in-degree of cyclic nodes will never go 0 and they wont add to queue
"""

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<V; i++){
            if(indegree[i]==0){
                q.offer(i);
            } 
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int n : adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0) q.offer(n);
            }
        }
        
        return count<V;
    }
}
