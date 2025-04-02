We iterate the array maintaining a sum and if a sum = sum-k occurred before in array then current sum contains k so we take out length by subtracting sum-k index from current index
Only put sum if it doesnt exist as we want longest subarray


class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int sum = 0;
        int len = 0;
        while(i<arr.length){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                len = Math.max(len,i-map.get(sum-k));
            }else if(sum==k){
                len = Math.max(len,i+1);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            i++;
        }
        return len;
        
    }
}
