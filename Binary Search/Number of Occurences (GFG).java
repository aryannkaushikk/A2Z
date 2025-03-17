// Same as First-Last Occurence you just need to count each occurence

class Solution {
    
    static int count(int[] arr, int target, int i, int j){
        if(i>j){
            return 0;
        }
        int mid = (i+j)/2;
        if(arr[mid]==target){
            return 1+count(arr,target,i,mid-1)+count(arr,target,mid+1,j);
        }else if(arr[mid]>target){
            return count(arr,target,i,mid-1);
        }else{
            return count(arr,target,mid+1,j);
        }
    }
    
    int countFreq(int[] arr, int target) {
        return count(arr,target,0,arr.length-1);
    }
}
