"""
Approach

For each move possible for A we calculate with every possible move of B
That means A can move in 3 directions and so can B
So for every direction of A we can check B in all 3
So 3x3 and we take the max out of all 9 and store in current cell
"""

"""
Recursion
"""

class Solution {

    static int pick(int i, int j1, int j2, int[][] grid){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
            return -10000;
        }
        if(i==grid.length-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        int max = -1;
        for(int dj1 = -1; dj1<=1; dj1++){
            for(int dj2 = -1; dj2<=1; dj2++){
                if(j1==j2) max = Math.max(grid[i][j1]+pick(i+1, j1+dj1, j2+dj2, grid), max);
                else max = Math.max(grid[i][j1]+grid[i][j2]+pick(i+1, j1+dj1, j2+dj2, grid), max);
            }
        }
        return max;
    }

    public int cherryPickup(int[][] grid) {
        return pick(0, 0, grid[0].length-1, grid);
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int pick(int i, int j1, int j2, int[][] grid, int[][][] dp){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
            return -10000;
        }
        if(i==grid.length-1){
            if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
            if(j1==j2){
                dp[i][j1][j2] = grid[i][j1];
            }
            else{
                dp[i][j1][j2] = grid[i][j1]+grid[i][j2];
            }
            return dp[i][j1][j2];
        }

        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        int max = -1;
        for(int dj1 = -1; dj1<=1; dj1++){
            for(int dj2 = -1; dj2<=1; dj2++){
                if(j1==j2) max = Math.max(grid[i][j1]+pick(i+1, j1+dj1, j2+dj2, grid, dp), max);
                else max = Math.max(grid[i][j1]+grid[i][j2]+pick(i+1, j1+dj1, j2+dj2, grid, dp), max);
            }
        }

        dp[i][j1][j2] = max;

        return dp[i][j1][j2];
    }

    public int cherryPickup(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][][] dp = new int[i][j][j];
        for(int k = 0; k<i; k++){
            for(int l = 0; l<j; l++){
                Arrays.fill(dp[k][l], -1);
            }
        }
        return pick(0, 0, grid[0].length-1, grid, dp);
    }
}

"""
Tabulation
"""

class Solution {
    
    public int cherryPickup(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][][] dp = new int[i][j][j];
        for(int j1 = 0; j1<j; j1++){
            for(int j2 = 0; j2<j; j2++){
                if(j1==j2) dp[i-1][j1][j2] = grid[i-1][j1];
                else dp[i-1][j1][j2] = grid[i-1][j1]+grid[i-1][j2];
            }
        }
        for(int x = i-2; x>=0; x--){
            for(int j1 = 0; j1<j; j1++){
                for(int j2 = 0; j2<j; j2++){
                    int max = -1;
                    for(int dj1 = -1; dj1<=1; dj1++){
                        for(int dj2 = -1; dj2<=1; dj2++){
                            if(j1+dj1<0 || j1+dj1>=j || j2+dj2<0 || j2+dj2>=j) continue;
                            if(j1==j2) max = Math.max( grid[x][j1] + dp[x+1][j1+dj1][j2+dj2], max);
                            else max = Math.max( grid[x][j1]+grid[x][j2] + dp[x+1][j1+dj1][j2+dj2], max);
                        }
                    }
                dp[x][j1][j2] = max;
                }   
            }
        }
        return dp[0][0][j-1];
    }
}

"""
Space Optimisation
"""

class Solution {

    public int cherryPickup(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[j][j];
        for(int j1 = 0; j1<j; j1++){
            for(int j2 = 0; j2<j; j2++){
                if(j1==j2) dp[j1][j2] = grid[i-1][j1];
                else dp[j1][j2] = grid[i-1][j1]+grid[i-1][j2];
            }
        }
        for(int x = i-2; x>=0; x--){
            int[][] temp = new int[j][j];
            for(int j1 = 0; j1<j; j1++){
                for(int j2 = 0; j2<j; j2++){
                    int max = -1;
                    for(int dj1 = -1; dj1<=1; dj1++){
                        for(int dj2 = -1; dj2<=1; dj2++){
                            if(j1+dj1<0 || j1+dj1>=j || j2+dj2<0 || j2+dj2>=j) continue;
                            if(j1==j2) max = Math.max( grid[x][j1] + dp[j1+dj1][j2+dj2], max);
                            else max = Math.max( grid[x][j1]+grid[x][j2] + dp[j1+dj1][j2+dj2], max);
                        }
                    }
                temp[j1][j2] = max;
                }   
            }
            dp = temp;
        }
        return dp[0][j-1];
    }
}
