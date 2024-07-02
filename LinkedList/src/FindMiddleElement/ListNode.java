package FindMiddleElement;

public class ListNode {

	static class Node {
		int data;
		Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {
			data = val;
			next = null;
		}
	}

	Node head;

	public ListNode() {
		head = null;
	}

	private void addLast(int i) {
		Node newNode = new Node(i);
		if (head == null) {
			head = newNode;
			return;
		}

		Node trav = head;
		while (trav.next != null) {

			trav = trav.next;
		}
		trav.next = newNode;
		
	
	}

	public int middleNode() {

		if (head == null) {
			//throw new RuntimeException("list is Empty  ! ");
				return 0;
		}

		if (head.next == null) {
			return head.data;
		}
		Node fast = head;
		Node slow = head;
		
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}
	
	public void display() {
		
		if(head == null) {
			return;
		}
		
		Node trav = head;
		while(trav != null) {
			System.out.println("-> "+trav.data);
			trav=trav.next;
		}
		
	}

	public static void main(String[] args) {
		ListNode l = new ListNode();
		l.addLast(10);
		l.addLast(20);
		l.addLast(30);
		l.addLast(40);
		l.addLast(50);
		
		l.display();
		
		System.out.println("mid Node"+l.middleNode());
		

	}

}
