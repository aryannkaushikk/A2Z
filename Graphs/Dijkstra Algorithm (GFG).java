"""
Approach

Single Source Shortest Path

Use a PQ or TreeSet to store a Pair (dist, node) which sorts according to dist

Picking the Pair with minimum dist each time, we relax the edges and only when an edge is relaxed we push that pair
"""

class Solution {
    
    static class Pair{
        int dist;
        int node;
        
        public Pair(int dist, int node){
            this.dist = dist;
            this.node = node;
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            adj.get(u).add(new int[] {v,w});
            adj.get(v).add(new int[] {u,w});
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.offer(new Pair(0, src));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int n = p.node;
            int d = p.dist;
            
            for(int[] ng: adj.get(n)){
                if( dist[ng[0]] > d+ng[1] ){
                    dist[ng[0]] = d+ng[1];
                    pq.offer(new Pair(dist[ng[0]], ng[0]));
                }
            }
        }
        
        return dist;
    }
}
