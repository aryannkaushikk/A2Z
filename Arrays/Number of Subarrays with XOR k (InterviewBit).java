public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int x = 0;
        for(int i = 0; i<A.size(); i++){
            x = x^A.get(i);
            if(map.containsKey(B^x)){
                count+=map.get(B^x);
            }
            if(map.containsKey(x)){
                int y = map.get(x);
                map.put(x,y+1);
            }else{
                map.put(x,1);
            }
        }
        return count;
    }
}
