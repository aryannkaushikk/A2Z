// Increase the window till size of map is not >2, when it is greater then find the leftMost element by checking lowest index present among all keys
// Remove that element and put l to that index+1
// Keep checking for max window size

  
class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r<fruits.length){
            map.put(fruits[r],r);
            if(map.size()>2){
                int leftMost = fruits.length;
                int leftKey = 0;
                for(int key : map.keySet()){
                    if(map.get(key)<leftMost){
                        leftMost = map.get(key);
                        leftKey = key;
                    }
                }
                map.remove(leftKey);
                l = leftMost+1;
            }
            max = Math.max(r-l+1,max);
            r++;
        }
        return max;
    }
}
