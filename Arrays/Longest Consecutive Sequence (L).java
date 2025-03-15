// Approach 1

// You will store each element in a HashSet to maintain no duplicacy.
// Then you will iterate again and for each element if there exists a value lesser than it (el-1) then continue,
// else the element is a starting point then you will check till how many elements ahead does the set has values from initial point and count them. 
// Store them in a max value after compare, return max in end.

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int n = nums.length;
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i<n; i++){
            map.add(nums[i]);
        }
        int max = 0;
        int count = 1;
        for(int i: map){
            if(!map.contains(i-1)){
                int x = i+1;
                count = 1;
                while(map.contains(x)){
                    count++;
                    x++;
                }
                max = Math.max(count,max);
            }
        }
        return max;

// Approach 2

// Sort the array and see till how many elements you get el+1==next element
        
        // Arrays.sort(nums);
        // int count = 1;
        // int max = Integer.MIN_VALUE;
        // for(int i = 0; i<nums.length-1; i++){
        //     if(nums[i]==nums[i+1]){
        //         continue;
        //     }
        //     if(nums[i]+1!=nums[i+1]){
        //         max = Math.max(count,max);
        //         count = 1;
        //         continue;
        //     }
        //     count++;
        // }
        // max = Math.max(count,max);
        // return max;
    }
}
