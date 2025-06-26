"""
Approach

Need to return Topological Sort Order
"""

"""
DFS
"""

class Solution {


    boolean dfs(int V, List<List<Integer>> adj, int[] vis, int[] pathVis, Stack<Integer> s){
        vis[V] = 1;
        pathVis[V] = 1;
        for(int i: adj.get(V)){
            if(pathVis[i]==1) return true;
            if(vis[i]==0 && dfs(i, adj, vis, pathVis, s)) return true;
        }

        s.push(V);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<prereq.length; i++){
            adj.get(prereq[i][1]).add(prereq[i][0]);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<numCourses; i++){
            if(vis[i]==0 && dfs(i, adj, vis, pathVis, s)) return new int[0];
        }

        int[] ans = new int[s.size()];
        for(int i = 0; i<ans.length; i++){
            ans[i] = s.pop();
        }

        return ans;
    }
}

"""
BFS
"""

class Solution {

    public int[] findOrder(int numCourses, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i<prereq.length; i++){
            adj.get(prereq[i][1]).add(prereq[i][0]);
            indegree[prereq[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
    
        for(int i = 0; i<numCourses; i++){
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

            ans.add(node);
        }

        int[] arr = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }

        return count==numCourses ? arr : new int[0];
    }
}
