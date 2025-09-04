"""
Approach

Djikstra Algorithm
Where PQ is based on maxEf
"""

class Solution {

    static class Tuple{
        int x;
        int y;
        int maxEf;

        public Tuple(int x, int y, int maxEf){
            this.x = x;
            this.y = y;
            this.maxEf = maxEf;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.maxEf-b.maxEf);
        int[][] dist = new int[n][m];
        pq.offer(new Tuple(0,0,0));
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int x = t.x;
            int y = t.y;
            int maxEf = t.maxEf;
            if (maxEf > dist[x][y]) continue;
            if(x==n-1 && y==m-1) return maxEf;
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    int newEf = Math.max(maxEf, Math.abs(heights[x][y]-heights[nx][ny]));
                    if(newEf < dist[nx][ny]){
                        pq.offer(new Tuple(nx, ny, newEf));
                        dist[nx][ny] = newEf;
                    }
                }
            }
        }
        return 0;
    }
}
