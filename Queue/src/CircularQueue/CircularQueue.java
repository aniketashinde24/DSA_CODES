package CircularQueue;

public class CircularQueue {
		private int []arr;
		private int rear,front;
		
		public CircularQueue(int size) {
			arr = new int[size];
			rear = -1;
			front = -1;
		}
		public boolean isFull() {
			return (front == rear && rear==arr.length-1)||
					(front == rear && front != -1);
		}
		public boolean isEmpty() {
			return ( rear == front && front == -1 );
		}
		public void push( int val ) {
			if( isFull()) 
				throw new RuntimeException("Queue is full ");
			rear =(rear + 1)% arr.length;
			arr[rear] = val;
		}
		public void pop() {
			if(isEmpty())
				throw new RuntimeException("Queue is Empty ");
			front= (front + 1)% arr.length;
			if(front == rear) {
				rear = -1;
				front = -1;
			}
		}
		public int peek() {
			if(isEmpty())
				throw new RuntimeException("Queue is Empty ");
			int index = (front + 1)% arr.length;
			return arr[index];
		}
		
		
	
	public static void main(String[] args) {
		
		CircularQueue q = new CircularQueue(5);
		
		q.push(10);
		q.push(20);
		q.push(30);
		q.push(40);
		q.push(50);
		
		q.pop();
		q.pop();
		q.pop();
		
		q.push(60);
		q.push(70);
		q.push(80);
	//	q.push(90);
		
		System.out.println(q.peek());
	//	System.out.println(q.peek());
		
		
		

	}

}
