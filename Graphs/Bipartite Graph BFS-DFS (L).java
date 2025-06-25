"""
Approach

In BFS
Before adding any neighbour, check if they are visited, if yes do they have same color as us? If yes, return false
If not visited then simply add to queue with other color

In DFS
Same story just dont add to queue but call function again
"""

class Solution {

    static class Pair {
        int x;
        int c;

        public Pair(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }

    boolean dfs(int color, int curr, int[][] graph, int[] vis) {
        if (vis[curr] != 0)
            return true;

        vis[curr] = color;

        for (int neighbor : graph[curr]) {
            if (vis[neighbor] == 0) {
                if (!dfs(3 - color, neighbor, graph, vis))
                    return false;
            } else if (vis[neighbor] == color) {
                return false;
            }
        }

        return true;
    }

    boolean bfs(int source, int[][] graph, int[] vis){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(source, 1));
        vis[source] = 1;


        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.x;
            int color = p.c;

            for (int neighbor : graph[node]) {
                if (vis[neighbor] == 0) {
                    q.offer(new Pair(neighbor, 3-color));
                    vis[neighbor] = 3-color;
                } else if (vis[neighbor] == color) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0 && !dfs(i, graph, vis))
                return false;
        }

        return true;
    }
}
