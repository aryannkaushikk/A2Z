"""
Approach

Pick No Pick
DP applied is NxTarget
"""

"""
Recursion
"""

class Solution {
    
    static Boolean sub(int[] arr, int tar, int sum, int i){
        if(i==arr.length) return sum==tar;
        if(sum==tar) return true;
        else if(sum>tar) return false;
        else{
            Boolean nopick = sub(arr, tar, sum, i+1);
            Boolean pick = sub(arr, tar, sum+=arr[i], i+1);
            
            return pick || nopick;
        }
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        return sub(arr, sum, 0, 0);
    }
}

"""
Recursion + Memoization
"""

class Solution {
    
    static Boolean sub(int[] arr, int sum, int i, int[][] dp){
        if(sum==0) return true;
        if(i==0) return sum==arr[0];
        
        if(dp[i][sum]!=-1) return dp[i][sum]==1;
        
        Boolean nopick = sub(arr, sum, i-1, dp);
        Boolean pick = false;
        if(sum>=arr[i]){
            pick = sub(arr, sum-arr[i], i-1, dp);
        }
        
        if(pick || nopick){
            dp[i][sum] = 1;
        }else{
            dp[i][sum] = 0;
        }
        
        return dp[i][sum]==1;
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        int[][] dp = new int[arr.length][sum+1];
        for(int i = 0; i<arr.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return sub(arr, sum, arr.length-1, dp);
    }
}

"""
Tabulation
"""

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean [][] dp = new boolean[arr.length][sum+1];
        for(int i = 0; i<arr.length; i++){
            dp[i][0] = true;
        }
        if(arr[0]<=sum) dp[0][arr[0]] = true;
        for(int i = 1; i<arr.length; i++){
            for(int j = 1; j<=sum; j++){
                Boolean nopick = dp[i-1][j];
                Boolean pick = false;
                if(j>=arr[i]){
                    pick = dp[i-1][j-arr[i]];
                }
                
                dp[i][j] = pick || nopick;
            }
        }
        return dp[arr.length-1][sum];
    }
}

"""
Space Optimisation
"""

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        if(arr[0]<=sum) dp[arr[0]] = true;
        for(int i = 1; i<arr.length; i++){
            boolean[] temp = new boolean[sum+1];
            for(int j = 0; j<=sum; j++){
                Boolean nopick = dp[j];
                Boolean pick = false;
                if(j>=arr[i]){
                    pick = dp[j-arr[i]];
                }
                
                temp[j] = pick || nopick;
            }
            dp = temp;
        }
        return dp[sum];
    }
}
