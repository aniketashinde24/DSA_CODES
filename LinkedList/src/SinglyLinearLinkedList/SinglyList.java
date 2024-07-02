package SinglyLinearLinkedList;

public class SinglyList {

	// Node is static member class of SinglyList
	static class Node {// why static class ? => we can directly access private member
		// in outer class.
		// Self referential class=> beacause it contain pointer of same type
		// Node class fields
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {

			this.data = val;
			this.next = null;
		}
	}

	// List class fields
	private Node head;

	public SinglyList() {
		head = null;
	}

	// display all nodes*****************************************************
	void display() {
		System.out.println("List  : ");
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
		System.out.println(" ");
	}

	// add node************************************************************
	void addFirst(int val) {
		// create new node and initialize it
		Node newNode = new Node(val);
		newNode.next = head;
		// head should point to new node
		head = newNode;

	}

	// add Last***************************************************

	void addLast(int val) {
		// create new node & init it
		Node newNode = new Node(val);

		// special 1. if list is empty, make new node as first node of list
		if (head == null) {
			head = newNode;
		}
		// general : add node at the end
		else {
			// traverse till last node
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			} // add new node after trav (trav.next)
			trav.next = newNode;
		}
	}
	// add Node at position
	void addAtPosition(int val, int position) {
		
		Node newNode = new Node(val);
		Node trav = head;
		
		for(int i = 1 ;i < position - 1; i++) {
			if(trav.next==null)
				break;
			trav = trav.next;
		}	
		newNode.next = trav.next;
		trav.next = newNode;
	}
	void deleteFirst()throws customeExc {
		if(head == null){
			throw new customeExc("there are no node ");
		}
		if(head.next == null) {
			head = null;
		}
			head=head.next;
	}

	 void deleteLast()throws customeExc {
		 if(head == null){
				throw new customeExc("there are no node ");
			}
		 Node trav ;
		 trav = head;
		 while(trav.next.next != null)
			 trav= trav.next;
		 
		 trav.next=null;
	 }

	public void deleteAtPosition(int pos)throws customeExc {
		if(pos == 1) {
			deleteFirst();
		}
			
		Node trav ;
		trav = head;
		Node temp = null;
		 if(head == null || pos < 1){
				throw new customeExc("List is empty  ");
			}
		 
		 for(int i = 0;i<pos-1;i++)
		 {	 temp = trav;
		 
			 trav=trav.next;
			
			 
		 }
		 temp.next=trav.next;
		 
		 
	}

}
