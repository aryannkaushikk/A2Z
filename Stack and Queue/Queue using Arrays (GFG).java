class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=-1;
		rear=-1;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    if(front==rear && front==-1){
	        front = 0;
	        rear = 0;
	        arr[front] = x;
	        return;
	    }
	    if((rear+1)%100005!=front){
	        rear = (rear+1)%100005;
	        arr[rear] = x;
	    }
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		if(front==rear && front==-1){
		    return -1;
		}
		int x = arr[front];
		if(front==rear){
		    front = -1;
		    rear = -1;
		    return x;
		}
		front = (front+1)%100005;
		return x;
	} 
}
