
class Solution{
    
    public static void deleteNode(Node temp){
        
    }
    
    Node removeDuplicates(Node head){
        if(head==null){
            return null;
        }
        Node temp = head;
        int x = Integer.MIN_VALUE;
        while(temp!=null){
            if(temp.data==x){
                Node back = temp.prev;
                Node front = temp.next;
                if(back==null && front==null){
                    return null;
                }else if(back==null){
                    temp.next = null;
                    front.prev = null;
                    temp = front;
                }else if(front==null){
                    back.next = null;
                    temp.prev = null;
                    return head;
                }else{
                    back.next = front;
                    front.prev = back;
                    temp.next = null;
                    temp.prev = null;
                    temp = front;
                }
            }else{
                x = temp.data;
                temp = temp.next;
            }
        }
        return head;
    }
}
