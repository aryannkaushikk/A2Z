class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            sum = sum+nums[i];
            if(sum==k){
                count++;
            }
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            if(map.containsKey(sum)){
                int x = map.get(sum);
                map.put(sum,x+1);
            }else{
                map.put(sum,1);
            }
        }
        return count;
    }
}
