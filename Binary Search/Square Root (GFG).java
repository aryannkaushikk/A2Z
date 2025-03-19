// From range 0-n, you find mid and then if square of mid is less than you search in mid+1-n to find greatest number whose sqaure<=n, if square of mid>n go left i.e. 0 - mid-1, and keep storing value to check max value.

class Solution {
    
    static int sqrt(int n, int[] ans, int low, int high){
        if(low>high){
            return ans[0];
        }
        int mid = (low+high)/2;
        int sqr = mid*mid;
        if(sqr==n){
            return mid;
        }
        else if(sqr>n){
            return sqrt(n,ans,low,mid-1); 
        }else{
            ans[0] = Math.max(ans[0],mid);
            return sqrt(n,ans,mid+1,high);
        }
    }
    
    int floorSqrt(int n) {
        int[] ans = {Integer.MIN_VALUE};
        return sqrt(n,ans,0,n);
    }
}

