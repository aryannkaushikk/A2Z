"""
Approach

We will keep an Ways array along with Dist array
Ways[i] shows number of ways (paths) to arrive at i with the shortest value paths
Whenever you encounter a shorter Dist for v from u, update Ways[v] = Ways[u] i.e. number of ways to arrive at v is equal to number of ways to arrive at u via the shortest path
If you encounter Dist[v]==Cost+w (Cost is Cost to arrive at u & w is cost from u->v) then update Ways[v] = Ways[v]+Ways[u] i.e we add Ways[u] ways as new number of ways to arrive at v
"""

class Solution {

    static class Pair{
        int node;
        long cost;

        public Pair(int node, long cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i<roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj[u].add(new int[]{v,w});
            adj[v].add(new int[]{u,w});
        }

        int MOD = 1000000007;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.cost, b.cost));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            long cost = p.cost;

            if(cost > dist[node]) continue;

            for(int[] neigh : adj[node]){
                int v = neigh[0];
                int w = neigh[1];

                if(dist[v] > cost+w){
                    dist[v] = cost+w;
                    pq.offer(new Pair(v, cost+w));
                    ways[v] = ways[node];
                }else if(dist[v]==cost+w){
                    ways[v] = (ways[v] + ways[node]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
} 
