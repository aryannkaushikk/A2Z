"""
Approach

Pretty Much Same to Paths Problem You are now just going to the index and index-1 of previous level
And at each level 0<=index<=level if not return MAX
"""

"""
Recursion
"""

class Solution {

    static int path(List<List<Integer>> triangle, int level, int index){
        if(index>level || index<0) return Integer.MAX_VALUE;
        if(level==0) return triangle.get(level).get(index);

        int left = path(triangle, level-1, index-1);
        int right = path(triangle, level-1, index);

        return triangle.get(level).get(index) + Math.min(left,right);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size()-1;
        int last = triangle.get(level).size();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<last; i++){
            min = Math.min(path(triangle, level, i), min);
        }
        return min;
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int path(List<List<Integer>> triangle, int level, int index, int[][] dp){
        if(index>level || index<0) return Integer.MAX_VALUE;
        if(level==0) return dp[level][index];

        if(dp[level][index]!=-1) return dp[level][index];

        int left = path(triangle, level-1, index-1, dp);
        int right = path(triangle, level-1, index, dp);

        dp[level][index] = triangle.get(level).get(index) + Math.min(left,right);

        return dp[level][index];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size()-1;
        int last = triangle.get(level).size();
        int[][] dp = new int[level+1][last];
        for(int i = 0; i<=level; i++){
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = triangle.get(0).get(0);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<last; i++){
            min = Math.min(path(triangle, level, i, dp), min);
        }
        return min;
    }
}

"""
Tabulation
"""

class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size()-1;
        int last = triangle.get(level).size();
        int[][] dp = new int[level+1][last];
        dp[0][0] = triangle.get(0).get(0);
        
        for(int i = 1; i<level+1; i++){
            for(int j = 0; j<i+1; j++){
                int left = Integer.MAX_VALUE;
                if(j>0) left = dp[i-1][j-1];
                int right = Integer.MAX_VALUE;
                if(j<i) right = dp[i-1][j];

                dp[i][j] = triangle.get(i).get(j) + Math.min(left,right);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<last; i++){
            min = Math.min(dp[level][i],min);
        }
        return min;
    }
}

"""
Space Optimisation
"""

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size()-1;
        int last = triangle.get(level).size();
        List<Integer> dp = new ArrayList<>();
        dp.add(triangle.get(0).get(0));
        
        for(int i = 1; i<level+1; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<i+1; j++){
                int left = Integer.MAX_VALUE;
                if(j>0) left = dp.get(j-1);
                int right = Integer.MAX_VALUE;
                if(j<i) right = dp.get(j);

                temp.add( triangle.get(i).get(j) + Math.min(left,right) );
            }
            dp = temp;
        }

        int min = Integer.MAX_VALUE;
        for(int i: dp){
            min = Math.min(min, i);
        }
        return min;
    }
}
