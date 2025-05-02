class Solution {
    
    static void facNum(long start, long curr, long n, ArrayList<Long> list){
        if(start*curr > n) return;
        curr = start*curr;
        list.add(curr);
        facNum(start+1, curr, n, list);
    }
    
    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> list = new ArrayList<>();
        facNum(1,1,n,list);
        return list;
    }
}
