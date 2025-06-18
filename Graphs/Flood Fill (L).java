"""
Approach

Same as Island Question
"""

class Solution {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void bfs(int[][] image, int sr, int sc, int color, int[][] vis){
        Queue<Pair> q = new LinkedList<>();
        int start = image[sr][sc];
        q.offer(new Pair(sr,sc));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            vis[x][y] = 1;
            image[x][y] = color;

            for(int d = 0; d<4; d++){
                if(x+dx[d]<0 || x+dx[d]>=image.length || y+dy[d]<0 || y+dy[d]>=image[0].length) continue;
                if(image[x+dx[d]][y+dy[d]]==start && vis[x+dx[d]][y+dy[d]]!=1) q.offer(new Pair(x+dx[d], y+dy[d]));
            }
        }
    }

    public void dfs(int[][] image, int sr, int sc, int color, int[][] vis){
        int start = image[sr][sc];
        image[sr][sc] = color;
        vis[sr][sc] = 1;

        for(int d = 0; d<4; d++){
            if(sr+dx[d]<0 || sr+dx[d]>=image.length || sc+dy[d]<0 || sc+dy[d]>=image[0].length) continue;
            if(image[sr+dx[d]][sc+dy[d]]==start && vis[sr+dx[d]][sc+dy[d]]!=1) dfs(image, sr+dx[d], sc+dy[d], color, vis);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] vis = new int[image.length][image[0].length];
        bfs(image, sr, sc, color, vis);
        return image;
    }
}
