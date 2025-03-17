// Since the array is unsorted we create lower bound for floor i.e. 
// When we find a value less than x, store it in min and then when another value less than x occurs,
// to use it the current value should be greater than min.
// So min acts as a lower bound.

// Similarly for ceil we set a upper bound max.

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
