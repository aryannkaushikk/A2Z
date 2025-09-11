"""
Approach

Prim's Algorithm

Push src with 0 wt -1 parent

If node is already visited, continue

Then for each node polled from PQ
Mark node visited
and only push its neighbours that are unvisited
"""

import java.util.*;
import java.io.*;

public class Solution {

    static class Tuple {
        int wt, node, par;
        Tuple(int wt, int node, int par) {
            this.wt = wt;
            this.node = node;
            this.par = par;
        }
    }

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (ArrayList<Integer> list : g) {
            int u = list.get(0) - 1;
            int v = list.get(1) - 1;
            int w = list.get(2);
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int[] vis = new int[n];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Tuple(0, 0, -1));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            int node = t.node;
            int par = t.par;
            int wt = t.wt;

            if (vis[node] == 1) continue;
            vis[node] = 1;

            if (par != -1) {
                ans.add(new ArrayList<>(Arrays.asList(par+1, node+1, wt)));
            }

            for (int[] neigh : adj.get(node)) {
                int v = neigh[0];
                int w = neigh[1];
                if (vis[v] == 0) {
                    pq.offer(new Tuple(w, v, node));
                }
            }
        }
        return ans;
    }
}
