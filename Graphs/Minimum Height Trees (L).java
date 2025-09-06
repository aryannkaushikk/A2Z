"""
Approach

Onion Peeling Method or Diameter->Center Method

We are eliminating all leaf nodes and making the nodes parent the new leaf nodes till 1 or 2 nodes only are not left
Because Think of the graph as a circle with roots with MHT at center (that will always be true) and there can be only 1 or 2 of them
So we eliminate from out to in until we get the center nodes

For that we are using indegree array and push to Q when indegree is 1 (leaf node)
"""

class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Collections.singletonList(0);
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
            indegree[u]++;
            indegree[v]++;
        }
        int remaining = n;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++) if(indegree[i]==1) q.offer(i);
        while(remaining>2){
            int size = q.size();
            remaining -= size;
            while(size-- > 0){
                int node = q.poll();
                for(int neigh : adj[node]){
                    indegree[neigh]--;
                    if(indegree[neigh]==1) q.offer(neigh);
                }
            }
        }
        return new ArrayList<>(q);
    }
}
