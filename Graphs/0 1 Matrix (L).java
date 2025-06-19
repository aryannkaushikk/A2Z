"""
Approach 1

BFS for each 1
"""

class Solution {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    int bfs(int[][] mat, int Vx, int Vy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {Vx, Vy});
        int step = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size--!=0){
                int Cx = q.peek()[0];
                int Cy = q.peek()[1];

                q.poll();
                if(mat[Cx][Cy]==0) return step;

                for(int i = 0; i<4; i++){
                    if(Cx+dx[i]>=0 && Cx+dx[i]<mat.length && Cy+dy[i]>=0 && Cy+dy[i]<mat[0].length) q.offer(new int[] {Cx+dx[i], Cy+dy[i]}); 
                }
            }
            step++;
        }

        return step;
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j]==1) ans[i][j] = bfs(mat, i, j);
            }
        }
        return ans;
    }
}

"""
Approach 2

Multi-point BFS

Push all zeroes in a Queue along with distance and mark them visited in a vis array
While q is not empty
Take each element out and push adjacent cells which are not visited along with dist+1
and mark current elements dist in ans array
"""

class Solution {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static class Point{
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    q.offer(new Point(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()){
            Point p = q.poll();
            int i = p.x;
            int j = p.y;
            int dist = p.dist;
            
            ans[i][j] = dist;
            for(int d=0; d<4; d++){
                if(i+dx[d]>=0 && i+dx[d]<mat.length && j+dy[d]>=0 && j+dy[d]<mat[0].length && vis[i+dx[d]][j+dy[d]]==0){
                    q.offer(new Point (i+dx[d], j+dy[d], dist+1));
                    vis[i+dx[d]][j+dy[d]] = 1;
                }
            }
        }

        return ans;
    }
}
