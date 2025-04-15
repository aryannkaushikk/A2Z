"""
Just Need to find index of PGE for each element
Using Deque instead of stack for performance optimality otherwise logic is same
"""

class StockSpanner {

    static class Pair{
        int val;
        int idx;

        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    private Deque<Pair> s;
    private int id;

    public StockSpanner() {
        s = new ArrayDeque<>();
        id = 0;
    }
    
    public int next(int price) {
        while(!s.isEmpty() && s.peek().val<=price){
            s.pop();
        }
        int x = id - (s.isEmpty() ? -1 : s.peek().idx); 
        s.push(new Pair(price,id));
        id++;
        return x;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
