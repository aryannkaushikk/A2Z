"""
Approach

This approach is based on state Management kind of approach

0 - Unvisited
1 - Visiting (in Recursion Stack)
2 - Safe

If u come at a node and its visited and not safe (state[v] == 1) meaning you came at a already visited node which means cycle hence cant lead to safe node so return false;
Returning false means this path is not leading to safe node hence the nodes on this path are not safe

If u come across a unvisited node
Then for all neighbours you call dfs and if any return false then this node returns false

Else mark this as safe and return true
"""

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) ans.add(i);
        }
        return ans;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] != 0) return state[node] == 2;
        state[node] = 1;
        for (int nei : graph[node]) {
            if (!dfs(nei, graph, state)) return false;
        }
        state[node] = 2;
        return true;
    }
}
