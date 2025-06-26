"""
Approach

Detect cycle in a Directed Graph
If cycle, false, else true.
"""
  
"""
DFS
"""

class Solution {


    boolean dfs(int V, List<List<Integer>> adj, int[] pathVis, int[] vis){
        vis[V] = 1;
        pathVis[V] = 1;
        for(int i: adj.get(V)){
            if(pathVis[i]==1) return true;
            if(pathVis[i]==0 && dfs(i, adj, pathVis, vis)) return true; 
        }

        pathVis[V] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(vis[i]==0 && dfs(i, adj, pathVis, vis)) return false;
        }

        return true;
    }
}

"""
BFS (Kahn)
"""

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<indegree.length; i++){
            if(indegree[i]==0) q.offer(i);
        }

        int count = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0) q.offer(i);
            }
        }

        return count==numCourses;
    }
}
