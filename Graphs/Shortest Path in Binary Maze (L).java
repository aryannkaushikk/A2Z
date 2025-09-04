"""
Approach

Since weights at each point is unit-based 
No need to use PQ can simply use Q
and to avoid adding Parent node back to Queue
Use grid as vis also by changing cell from 0->1 when visited
"""

class Solution {

    static class Tuple{
        int x;
        int y;
        int dist;

        public Tuple(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0) return -1;
        int n = grid.length;
        if(n==1) return 1;
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, 0, 1));
        while(!pq.isEmpty()){
                Tuple t = pq.poll();
                int x = t.x;
                int y = t.y;
                int dist = t.dist;
                for(int i = 0; i<8; i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && grid[nx][ny]==0){
                        if(nx==n-1 && ny==n-1) return dist+1;
                        grid[nx][ny] = 1;
                        pq.offer(new Tuple(nx, ny, dist+1));
                    }
                }
        }
        return -1;
    }
}
