// Same approach as finding square root

class Solution {
    
    public static int bs(int n, int m, int low, int high, int[] max){
        if(low>high){
            return max[0];
        }
        int mid = (low+high)/2;
        int x = (int) Math.pow(mid,n);
        if(x==m){
            return mid;
        }else if(x>m){
            return bs(n,m,low,mid-1,max);
        }else{
            max[0] = Math.max(max[0],mid);
            return bs(n,m,mid+1,high,max);
        }
    }
    
    public int nthRoot(int n, int m) {
        int[] max = {-1};
        int x = bs(n,m,1,m,max); 
        if( (int) Math.pow(x,n)==m){
            return x;
        }
        return -1;
    }
}
