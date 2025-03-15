// Prefix Sum used.
// In the hashMap we are storing sum, count of sum occurred.
// Everytime you encounter a sum that is equal to an existing sum you increase the value of the key(sum).
// And then everytime you use the value you add its value not +1 to count.

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
