// Prefix Sum based approach
// We Hash Sum at each point when sum!=0 and if sum==0 then max length  = i+1 where i is index where sum == 0
// If sum is not zero we check if the current sum value occured anywhere before in array meaning from that index till now the whole subarray got zero.

class Solution {
    int maxLen(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            if(sum==0){
                max = i+1;
            }
            else{
                if(map.containsKey(sum)){
                    max = Math.max(max,i-map.get(sum));
                }else{
                    map.put(sum,i);    
                }
            }
        }
        return max;
    }
}
