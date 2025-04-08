class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
	    if(front==null){
	        QueueNode t = new QueueNode(a);
	        front = t;
	        rear = t;
	        return;
	    }
	    QueueNode t = new QueueNode(a);
	    rear.next = t;
	    rear = t;
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        if(front==null){
            return -1;
        }
        int x = front.data;
        if(front==rear){
            front = null;
            rear = null;
        }else{
            front = front.next;    
        }
        return x;
	}
}
