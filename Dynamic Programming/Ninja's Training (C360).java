"""
Approach

We are choosing max possible points activity which is not equal to the last day's activity.
And we are trying to do this for all last day's activity for each day
"""

"""
Recursion
"""

import java.util.*;
public class Solution {

    static int ninja(int[][] points, int day, int last){
        if(day==0{
            int max = 0;
            for(int i = 0; i<3; i++){
                if(i!=last){
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
        }
        int max = 0;
        for(int i = 0; i<3; i++){
            if(i!=last){
                int point = points[day][i] + ninja(points, day-1, i, dp);
                max = Math.max(point, max);
            }
        }
        return max;
    }


    public static int ninjaTraining(int n, int points[][]) {
        return ninja(points, n-1, 3);
    }
}

"""
Recursion + Memoization
"""

import java.util.*;
public class Solution {

    static int ninja(int[][] points, int day, int last, int[][]dp){
        if(day==0){
            if(dp[day][last]!=-1) return dp[day][last];
            int max = 0;
            for(int i = 0; i<3; i++){
                if(i!=last){
                    max = Math.max(max, points[day][i]);
                }
            }
            dp[day][last] = max;
            return dp[day][last];
        }
        if(dp[day][last]!=-1) return dp[day][last];
        int max = 0;
        for(int i = 0; i<3; i++){
            if(i!=last){
                int point = points[day][i] + ninja(points, day-1, i, dp);
                max = Math.max(point, max);
            }
        }
        dp[day][last] = max;
        return dp[day][last];
    }


    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return ninja(points, n-1, 3, dp);
    }

}

"""
Tabulation
"""

import java.util.*;
public class Solution {

    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(Math.max(points[0][0],points[0][1]), points[0][2]);
        int res = 0;
        for(int day = 1; day<n; day++){
            for(int last = 0; last<4; last++){
                int max = 0;
                for(int i = 0; i<3; i++){
                    if(i!=last){
                        int point = points[day][i] + dp[day-1][i];
                        max = Math.max(max, point);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[n-1][3];
    }

}

"""
Space Optmisation
"""

import java.util.*;
public class Solution {

    public static int ninjaTraining(int n, int points[][]) {
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(Math.max(points[0][0],points[0][1]), points[0][2]);
        int res = 0;
        for(int day = 1; day<n; day++){
            int[] dp2 = new int[4];
            for(int last = 0; last<4; last++){
                int max = 0;
                for(int i = 0; i<3; i++){
                    if(i!=last){
                        int point = points[day][i] + dp[i];
                        max = Math.max(max, point);
                    }
                }
                dp2[last] = max;
            }
            dp = dp2;
        }
        return dp[3];
    }

}
