"""
Approach

Its a customized use of Djikstra
We dont use PQ but Q
Because we want entries sorted on stops and Q can handle it without using PQ as we get lesser stops first 
And we maintain a dist array and follow djisktra only
"""

class Solution {


    static class Pair{
        int node;
        int cost;
        int stop;

        public Pair(int node, int cost, int stop){
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            adj[u].add(new int[]{v,w});
        }

        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(src, 0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int cost = p.cost;
            int stop = p.stop;
            if(stop>k) continue;
            for(int[] neigh : adj[node]){
                int v = neigh[0];
                int w = neigh[1];

                if(dist[v] > cost+w){
                    pq.offer(new Pair(v, cost+w, stop+1));                    
                    dist[v] = cost + w;
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
