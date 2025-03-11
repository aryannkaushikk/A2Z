class Solution {

    public static int bs(int[] arr, int i, int j){
        if(i>j){
            return 0;
        }
        if(i==j){
            return arr[i];
        }
        int mid = (i+j)/2;
        if(arr[mid+1]==arr[mid]) {
            if(mid%2==0){
                return bs(arr,mid+2,j);
            }
            return bs(arr, i,mid-1);
        }else if(arr[mid-1]==arr[mid]){
            if(mid%2==0){
                return bs(arr,i,mid-2);
            }
            return bs(arr,mid+1,j);
        }else{
            return arr[mid];
        }
    }

    public int singleNonDuplicate(int[] nums) {
        return bs(nums,0,nums.length-1);
    }
}
