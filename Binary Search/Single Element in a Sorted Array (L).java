// In this we check if the mid element has any duplicates before it or after it.
// If none then its the required element.
// If it has behind it and the mid is even that mean i to mid is odd and since we have a pair already then there exists one element without pair, if mid odd then i to mid is even length then search forward.
// If it has ahead of it and the mid is even that mean i to mid is odd and since we have a pair already and the mid is a plus one so you search ahead, if mid odd then i to mid is even length ans since mid is an extra that leaves pairs plus one so you search behind.

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
