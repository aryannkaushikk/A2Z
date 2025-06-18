"""
Approach
  
Again similar to island problem but use BFS specifically
Also begin the queue by pushing all rotten first
"""

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenQueue = new LinkedList();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 2)
                {
                    rottenQueue.add(new int[] {i, j});
                }
                if (grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int timeCount = -1;
        int[] rowDir = new int[] {0, -1, 0, 1};
        int[] colDir = new int[] {-1, 0, 1, 0};
        while (!rottenQueue.isEmpty())
        {
            int size = rottenQueue.size();
            while (size > 0)
            {
                int[] currentOrange = rottenQueue.remove();
                for (int dir = 0; dir < 4; dir++)
                {
                    int nextRow = currentOrange[0] + rowDir[dir];
                    int nextCol = currentOrange[1] + colDir[dir];
                    if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol] == 1)
                    {
                        grid[nextRow][nextCol] = 2;
                        rottenQueue.add(new int[] {nextRow, nextCol});
                        fresh--;
                    }
                }

                size--;
            }
            
            timeCount++;
        }

        return fresh == 0 ? timeCount : -1;
    }
}
