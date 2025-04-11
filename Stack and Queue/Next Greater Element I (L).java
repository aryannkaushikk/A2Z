"""
Approach 1 ( O(n^2) )

Start from the left and keep scanning for the next largest from i+1
"""

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] map = new int[10001];
        for(int i = 0; i<nums2.length; i++){
            map[nums2[i]] = i;
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i<nums1.length; i++){
            int x = map[nums1[i]];
            ans[i] = -1;
            for(int j = x+1; j<nums2.length; j++){
                if(nums2[j]>nums1[i]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}

"""
Approach 2 ( O(2n) )

Start from right and while top element of stack is less than equal to current element, pop.
If stack got empty then -1 else top element.
"""

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n1; i++){
            map.put(nums1[i],i);
        }
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n1];
        for(int i = n2-1; i>=0; i--){
            if(map.containsKey(nums2[i])){
                int id = map.get(nums2[i]);
                ans[id] = -1;
                while(!s.isEmpty() && s.peek()<=nums2[i]){
                    s.pop();
                }
                if(!s.isEmpty()) ans[id] = s.peek();
            }
            s.push(nums2[i]);
        }
        return ans;
    }
}
