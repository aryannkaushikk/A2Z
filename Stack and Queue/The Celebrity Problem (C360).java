"""
Approach

Starting from taking 0 as candidate
Check for 1 to n-1
If candidate knows i, then i is candidate
At end you get the potential celebrity
Next verify by iterating from 0 to n-1
When candidate!=i then candidate should not know i and i should know candidate, if not return -1
Else return candidate
  """

import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
		int candidate = 0;
		for(int i = 1; i<n; i++){
			if(Runner.knows(candidate,i)){
				candidate = i;
			}
		}
		for(int i = 0; i<n; i++){
			if(candidate!=i){
				if(!Runner.knows(i,candidate) || Runner.knows(candidate,i)){
					return -1; 
				}
			}
		}
		return candidate;
    }
}
