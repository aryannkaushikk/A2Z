"""
Approach

Core use of Stack is to back track to asteroid which did not get destroyed by other
Add to stack if asteroid is positive or stack is empty (nothing to collide) or top is negative (same directions dont collide)
Else
Keep removing from stack till current asteroid is bigger than stack[top] then add asteroid to stack if stack got empty or top is negative meaning it destroyed all didnt get destroyed but if two asteroids of same size collided then dont add
In end return stack from bottom to top 
"""

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] s = new int[n];
        int top = -1;
        for(int i = 0; i<n; i++){
            if(asteroids[i]>0 || top==-1 || s[top]<0){
                s[++top] = asteroids[i];
            }else{
                boolean flag = false;
                while(top!=-1 && s[top]>0 && s[top]<=Math.abs(asteroids[i])){
                    if(s[top]==Math.abs(asteroids[i])){
                        top--;
                        flag = true;
                        break;
                    }
                    top--;
                }
                if((top==-1 || s[top]<0) && !flag){
                    s[++top] = asteroids[i];
                }
            }
        }
        int[] ans = new int[top+1];
        while(top!=-1){
            ans[top] = s[top];
            top--;
        }
        return ans;
    }
}
