"""
Approach
  
Again similar to island problem but use BFS specifically
Also begin the queue by pushing all rotten first
"""

class Solution {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int bfs(int[][] grid, List<Pair> list){
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        for(Pair p: list){
            q.offer(new Pair(p.x,p.y));
        }

        while(!q.isEmpty()){
            boolean flag = false;
            int size = q.size();
            while(size!=0){
                Pair p = q.poll();
                int px = p.x;
                int py = p.y;

                for(int d = 0; d<4; d++){
                    if(dx[d]+px<0 || dx[d]+px>=grid.length || dy[d]+py<0 || dy[d]+py>=grid[0].length || grid[dx[d]+px][dy[d]+py]==0 || grid[dx[d]+px][dy[d]+py]==2) continue;
                    flag = true;
                    grid[dx[d]+px][dy[d]+py] = 2;
                    q.offer(new Pair(dx[d]+px, dy[d]+py));
                }
                size--;
            }
            if(flag) count++;
        }
        return count;
    }

    public int orangesRotting(int[][] grid) {
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    list.add(new Pair(i,j));
                }
            }
        }

        int count = bfs(grid, list);

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return count;
    }
}
