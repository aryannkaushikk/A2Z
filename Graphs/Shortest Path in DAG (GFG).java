"""
Approach

Toposort using DFS

Create a dist array with infinity values
dist[source] = 0
Then Empty stack one by one
Let v be node at top and d distance to reach that node from dist array
Iterate all neighbours and check if d+(u,v) is less than dist[n] i.e. the distance stored to reach neighbour is higher than to reach till u then from u to v
If yes, relax the edge
Skip V if d is infinity

In end, make infinity dist to -1
"""

class Solution {
    
    
    void dfs(List<List<int[]>> adj, int V, int[] vis, Stack<Integer> s){
        vis[V] = 1;
        
        for(int[] n: adj.get(V)){
            if(vis[n[0]]!=1) dfs(adj, n[0], vis, s);
        }
        
        s.push(V);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[V];
        List<List<int []>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length; i++){
            adj.get(edges[i][0]).add(new int[] {edges[i][1], edges[i][2]});
        }
        for(int i = 0; i<V; i++){
            if(vis[i]==0) dfs(adj, 0, vis, s);
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while(!s.isEmpty()){
            int v = s.pop();
            int d = dist[v];
            
            if(d==Integer.MAX_VALUE) continue;
            
            for(int[] n: adj.get(v)){
                dist[n[0]] = Math.min(dist[n[0]], d+n[1]);
            }
        }
        
        for(int i = 0; i<V; i++){
            if(dist[i]==Integer.MAX_VALUE) dist[i] = -1;
        }
        
        return dist;
    }
}
