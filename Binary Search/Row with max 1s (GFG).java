// In each row use binary search to find minimum index at which 1 is present (row length- index +1)  = number of 1s
// Compare for each row and return row with max ones that occured first.


class Solution {
    
    static int count1s(int[][] arr, int row){
        int low = 0;
        int high = arr[row].length-1;
        int max = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[row][mid]==1){
                max = Math.max(max,arr[row].length-mid+1);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return max;
    }
    
    public int rowWithMax1s(int arr[][]) {
        int max = -1;
        int row = -1;
        for(int i = 0; i<arr.length; i++){
            int temp = count1s(arr,i);
            if(max<temp){
                max = temp;
                row = i;
            }
        }
        return row;
    }
}
