"""
Approach

BFS-based
Start BFS from source
If distance of neighbour in dist array is infinity, relax it
"""


class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        
        while(!q.isEmpty()){
            int V = q.poll();
            int d = dist[V];
            
            if(d==Integer.MAX_VALUE) continue;
            
            for(int n: adj.get(V)){
                if(dist[n]==Integer.MAX_VALUE){
                    dist[n] = d+1;
                    q.offer(n);   
                }
            }
        }
        
        for(int i = 0; i<dist.length; i++){
            if(dist[i]==Integer.MAX_VALUE) dist[i] = -1;
        }
        
        return dist;
    }
}
