// The index of min element of array is how many times the array was right rotated.

class Solution {
    
    public static int bs(List<Integer> arr, int i, int j){
        if(i>j){
            return -1;
        }
        int mid = (i+j)/2;
        if(arr.get(i)<=arr.get(j)){
            return i;
        }
        if(mid-1>=0 && mid+1<arr.size() && arr.get(mid)<arr.get(mid+1) && arr.get(mid)<arr.get(mid-1)){
            return mid;
        }else if(mid-1>=0 && mid+1>=arr.size() && arr.get(mid)<arr.get(mid-1)){
            return mid;
        }else if (mid-1<0 && mid+1<arr.size() && arr.get(mid)<arr.get(mid+1)){
            return mid;
        }else if (arr.get(i)<=arr.get(mid)){
            return bs(arr,mid+1,j);
        }else{
            return bs(arr,i,mid-1);
        }
    }
    
    public int findKRotation(List<Integer> arr) {
        return bs(arr,0,arr.size()-1);
    }
}
