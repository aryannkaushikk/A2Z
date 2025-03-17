// Binary Search Approach
// If the mid element is equal to or less than x then you search in the array ahead to find greater value which might be less than current value but less than or equal to x
// Else you are at a element way greater than x so go in behind array. 

class Solution {
    
    static int min;
    static int idx;
    
    static void floor(int[] arr, int x, int i, int j){
        if(i>j){
            return;
        }
        int mid = (i+j)/2;
        if(arr[mid]<=x){
            if(arr[mid]>=min){
                min = arr[mid];
                idx = mid;
            }
            floor(arr,x,mid+1,j);
        }else{
            floor(arr,x,i,mid-1);
        }
    }

    static int findFloor(int[] arr, int x) {
        min = Integer.MIN_VALUE;
        idx = -1;
        floor(arr,x,0,arr.length-1);
        return idx;
    }
}
