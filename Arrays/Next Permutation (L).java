class Solution {

    public static void reverse(int[] arr, int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums.length==1){
            return;
        }
        int n = nums.length;
        int i = n-2;
        while(i>=0){
            if(nums[i]<nums[i+1]){
                break;
            }
            i--;
        }
        if(i==-1){
            reverse(nums,0,n-1);
            return;
        }
        for(int j = n-1; j>i; j--){
            if(nums[j]>nums[i]){
                int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        break;
            }
        }
        reverse(nums,i+1,n-1);
    }
}
