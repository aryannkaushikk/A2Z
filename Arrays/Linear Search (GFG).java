
class Solution {
    static boolean searchInSorted(int arr[], int k) {
        for(int i=0; i<arr.length && arr[i]<=k; i++){
            if(arr[i]==k){
                return true;
            }
        }
        return false;
    }
}
