// Binary Search Approach

// For Floor
// If the mid element is equal to or less than x then you search in the array ahead to find value which might be greater than current value but less than or equal to x
// Else you are at a element way greater than x so go in behind array. 

// For Ceil
// If the mid element is equal to or greater than x then you search in the array behind to find value which might be lesser than current value but greater than or equal to x
// Else you are at a element way lesser than x so go in ahead array.


class Solution {
    
    static int min;
    static int idxMin;
    
    static void floor(int[] arr, int x, int i, int j){
        if(i>j){
            return;
        }
        int mid = (i+j)/2;
        if(arr[mid]<=x){
            if(arr[mid]>=min){
                min = arr[mid];
                idxMin = mid;
            }
            floor(arr,x,mid+1,j);
        }else{
            floor(arr,x,i,mid-1);
        }
    }
    
    static int max;
    static int idxMax;
    
    static void ceil(int[] arr, int x, int i, int j){
        if(i>j){
            return;
        }
        int mid = (i+j)/2;
        if(arr[mid]>=x){
            if(arr[mid]<=max){
                max = arr[mid];
                idxMax = mid;
            }
            ceil(arr,x,i,mid-1);
        }else{
            ceil(arr,x,mid+1,j);
        }
    }
    
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
        idxMin = -1;
        idxMax = -1;
        floor(arr,x,0,arr.length-1);
        ceil(arr,x,0,arr.length-1);
        int[] ans = new int[2];
        if(idxMin==-1){
            ans[0] = idxMin;
        }else{
            ans[0] = min;    
        }
        if(idxMax==-1){
            ans[1] = idxMax;
        }else{
            ans[1] = max;    
        }
        return ans;
    }
}
