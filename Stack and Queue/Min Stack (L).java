"""
Appraoch 1

Create a class Pair which store curr_val, min_val
Each time you encounter a new min_value push the curr_val with the new min_val
"""

class MinStack {

    static class Pair{
        int val;
        int min;

        public Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> s;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(new Pair(val,val));
        }else{
            int x = s.peek().min;
            if(x>val){
                s.push(new Pair(val,val));
            }else{
                s.push(new Pair(val,x));
            }
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;        
    }
    
    public int getMin() {
        return s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
