
// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int x = Integer.MIN_VALUE;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                if(a[i]!=x){
                    list.add(a[i]);
                    x = a[i];
                }        
                i++;
            }else{
                if(b[j]!=x){
                    list.add(b[j]);
                    x = b[j];    
                }
                j++;
            }
        }
        while(i<a.length){
            if(a[i]!=x){
                    list.add(a[i]);
                    x = a[i];
                }        
            i++;
        }
        while(j<b.length){
            if(b[j]!=x){
                    list.add(b[j]);
                    x = b[j];
                }        
            j++;
        }
        return list;
    }
}
