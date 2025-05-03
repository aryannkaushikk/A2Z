"""
Approach

Store as a pair and maintain max value along with each element
"""

import java.util.*;
public class MaxStack {

	static class Pair{
		int val;
		int max;

		public Pair(int val, int max){
			this.val = val;
			this.max = max;
		}
	}

	Stack<Pair> s;

	public MaxStack() {
		s = new Stack<>();
	}

	public void specialPush(int value) {
		if(s.isEmpty() || s.peek().max<value){
			s.push(new Pair(value,value));
		}else{
			s.push(new Pair(value,s.peek().max));
		}
	}

	// Return the popped value.
	public int specialPop() {
		if(s.isEmpty()) return -1;
		return s.pop().val;
	}

	// Return the value at the top of stack.
	public int specialTop() {
		if(s.isEmpty()) return -1;
		return s.peek().val;
	}

	// Return the maximum value in stack.
	public int specialMax() {
		if(s.isEmpty()) return -1;
		return s.peek().max;
	}
}
