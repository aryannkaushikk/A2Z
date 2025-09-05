"""
Approach

Solved it using Shortest Path Algorithm with Q
Djikstra also works but is a bit slower due to log n
"""

class Solution {

    static class Pair{
        int node;
        int cost;

        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1];
        for(int i = 0; i<=n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i<times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj[u].add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<Pair> pq = new ArrayDeque<>();
        pq.offer(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int cost = p.cost;

            for(int[] neigh : adj[node]){
                int v = neigh[0];
                int w = neigh[1];

                if(dist[v] > cost+w){
                    dist[v] = cost+w;
                    pq.offer(new Pair(v, cost+w));
                }
            }
        }
        int max = -1;
        for(int i = 1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            if(max<dist[i]) max=dist[i];
        }
        return max;
    }
}
