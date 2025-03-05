
/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        if(head==null){
            return null;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node last = head;
        int l = 1;
        while(last.next!=null){
            last = last.next;
            l++;
        }
        int i = 1;
        Node temp = head;
        while(i<l){
            if(temp.data+last.data==target){
                ArrayList<Integer> x = new ArrayList<>();
                x.add(temp.data);
                x.add(last.data);
                list.add(x);
                temp = temp.next;
                last = last.prev;
                i++;
                l--;
            }else if(temp.data+last.data>target){
                last = last.prev;
                l--;
            }else{
                temp = temp.next;
                i++;
            }
        }
        return list;
    }
}
