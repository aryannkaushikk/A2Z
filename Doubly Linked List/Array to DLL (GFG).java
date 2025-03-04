class Solution {
    Node constructDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i = 1; i<arr.length; i++){
            Node t = new Node(arr[i]);
            t.prev = temp;
            temp.next = t;
            temp = t;
        }
        return head;
    }
}
