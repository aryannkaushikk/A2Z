/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        if(head==null){
            return null;
        }
        // DLLNode temp = head;
        // while(true){
        //     DLLNode back = temp.prev;
        //     DLLNode front = temp.next;
        //     if(front==null && back==null){
        //         return head;
        //     }
        //     if(front==null){
        //         temp.next = back;
        //         break;
        //     }
        //     temp.prev = front;
        //     temp.next = back;
        //     temp = temp.prev;
        // }
        // return temp;
        
        DLLNode last = head;
        int a = 0;
        int b = 1;
        while(last.next!=null){
            last = last.next;
            b++;
        }
        DLLNode temp = head;
        while(a<b){
            int i = temp.data;
            temp.data = last.data;
            last.data = i;
            temp = temp.next;
            last = last.prev;
            a++;
            b--;
        }
        return head;
    }
}
