package SinglyLinearLinkedList_Reverse;

public class List {

	static class Node {
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {
			data = val;
			next = null;
		}
	}

	private Node head;

	public List() {
		head = null;
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		}
		Node trav = head;

		while (trav.next != null) {
			trav = trav.next;
		}
		trav.next = newNode;
		newNode.next = null;

	}

	public void reverse() {
		Node oldHead = head;
		Node temp = oldHead;
		head = null;
		while (oldHead != null) {
			temp = oldHead;
			oldHead = oldHead.next;
			temp.next = head;
			head = temp;
		}
	}

	public void display() {
		Node trav = head;
		System.out.println("List : ");
		while (trav != null) {
			System.out.println(trav.data + "->");
			trav = trav.next;
		}
	}

	public static void main(String[] args) {

		List list = new List();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
		list.reverse();
		list.display();

	}

}
