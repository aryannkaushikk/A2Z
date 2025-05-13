"""
Approach

Everytime you reach 0th index
If tar is 0 AND num[0] = 0 then we get 2 subsets one with choosing num[0], one without
If tar is 0 OR tar==num[0] then we get 1

Same Pick No Pick
"""

"""
Recursion
"""

import java.util.*;
import java.io.*;

public class Solution {
    
    public static int subSum(int[] num, int i, int tar){
        if(i==0){
            if(tar==0 && 0==num[0]) return 2;
            if(tar==0 || tar==num[0]) return 1;
            return 0;
        } 

        int nopick = subSum(num, i-1, tar);
        int pick = 0;

        if(num[i]<=tar){
            pick = subSum(num, i-1, tar-num[i]);
        }

        return pick+nopick;
    }

    public static int findWays(int num[], int tar) {
        return subSum(num, num.length-1, tar) % (1000000000 + 7);
    }
}
  
"""
Recursion + Memoization
"""

import java.util.*;
import java.io.*;

public class Solution {

    static final int MOD = 1_000_000_007;
    
    public static int subSum(int[] num, int i, int tar, int[][] dp){
        if(i==0){
            if(tar==0 && 0==num[0]) return dp[i][tar] = 2;
            if(tar==0 || tar==num[0]) return dp[i][tar] = 1;
            return dp[i][tar] = 0;
        } 

        if(dp[i][tar]!=-1) return dp[i][tar];

        int nopick = subSum(num, i-1, tar, dp);
        int pick = 0;

        if(num[i]<=tar){
            pick = subSum(num, i-1, tar-num[i], dp);
        }

        return dp[i][tar] = (pick + nopick) % MOD;
    }

    public static int findWays(int num[], int tar) {
        int[][] dp = new int[num.length][tar+1];
        for(int i = 0; i<num.length; i++){
            Arrays.fill(dp[i], -1);
        }
        subSum(num, num.length-1, tar, dp);
        return dp[num.length-1][tar];
    }
}
  
"""
Tabulation
"""

import java.util.*;
import java.io.*;

public class Solution {

    static final int MOD = 1_000_000_007;
    
    public static int findWays(int num[], int tar) {
        int[][] dp = new int[num.length][tar+1];
        if (num[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (num[0] != 0 && num[0] <= tar) {
            dp[0][num[0]] = 1;
        }
        for(int i = 1; i<num.length; i++){
            for(int j = 0; j<=tar; j++){
                int nopick = dp[i-1][j];
                int pick = 0;

                if(num[i]<=j){
                    pick = dp[i-1][j-num[i]];
                }

                dp[i][j] = (pick + nopick) % MOD;
            }
        }
        return dp[num.length-1][tar];
    }
}
  
"""
Space Optimisation
"""

import java.util.*;
import java.io.*;

public class Solution {

    static final int MOD = 1_000_000_007;
    
    public static int findWays(int num[], int tar) {
        int[] dp = new int[tar+1];
        
        if (num[0] == 0) {
            dp[0] = 2;
        } else {
            dp[0] = 1;
        }

        if (num[0] != 0 && num[0] <= tar) {
            dp[num[0]] = 1;
        }


        for(int i = 1; i<num.length; i++){
            int[] temp = new int[tar+1];
            for(int j = 0; j<=tar; j++){
                int nopick = dp[j];
                int pick = 0;

                if(num[i]<=j){
                    pick = dp[j-num[i]];
                }

                temp[j] = (pick + nopick) % MOD;
            }
            dp = temp;
        }
        return dp[tar];
    }
}
