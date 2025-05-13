"""
Approach

Same as Subset with Target Sum but this only works with Tabulation as we need the last row of DP fully filled to find how close to sum/2 can the subset sum be so that Abs Diff will be minimum
"""

"""
Tabulation
"""

import java.util.Arrays;
public class Solution {

    public static int minSubsetSumDifference(int []arr, int n) {
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum+=arr[i];
        }
        boolean[][] dp = new boolean[n][(sum/2)+1];
        dp[0][0] = true;
        if(arr[0]<=sum/2) dp[0][arr[0]] = true;
        for(int i = 1; i<n; i++){
            for(int s = 0; s<=sum/2; s++){
                boolean nopick = dp[i-1][s];
                boolean pick = false;
                
                if(arr[i]<=s){
                    pick = dp[i-1][s-arr[i]];
                }

                dp[i][s] = pick || nopick;
            }
        }
        int min = sum;
        for(int i = sum/2; i>=0; i--){
            if(dp[n-1][i]==true){
                min = sum - 2 * i;
                break;
            }
        }
        return min;
    }
}

"""
Space Optimisation
"""

import java.util.Arrays;
public class Solution {

    public static int minSubsetSumDifference(int []arr, int n) {
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum+=arr[i];
        }
        boolean[] dp = new boolean[(sum/2)+1];
        dp[0] = true;
        if(arr[0]<=sum/2) dp[arr[0]] = true;
        for(int i = 1; i<n; i++){
            boolean[] temp = new boolean[(sum/2)+1];
            for(int s = 0; s<=sum/2; s++){
                boolean nopick = dp[s];
                boolean pick = false;
                
                if(arr[i]<=s){
                    pick = dp[s-arr[i]];
                }

                temp[s] = pick || nopick;
            }
            dp = temp;
        }
        int min = sum;
        for(int i = sum/2; i>=0; i--){
            if(dp[i]==true){
                min = sum - 2 * i;
                break;
            }
        }
        return min;
    }
}
