package BST_without_recursion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import BST_without_recursion.BinarySearchTree.Node;

class BinarySearchTree {

	static class Node {
		// Node fields
		private int data;
		private Node left, right;

		// Node methods
		public Node() {
			data = 0;
			left = null;
			right = null;
		}

		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}

		public int getData() {
			return data;
		}

	}

	// Tree fields
	private Node root;

	// Tree methods
	public BinarySearchTree() {
		root = null;
	}

	public void add(int val) {
		Node newNode = new Node(val);
		if (root == null)
			root = newNode;
		else {
			Node trav = root;
			while (true) {
				if (val < trav.data) {
					if (trav.left != null)
						trav = trav.left;
					else {// no child in left
						trav.left = newNode;
						break;
					}
				} else {// if(val >= trav.data)
					if (trav.right != null)
						trav = trav.right;
					else {// no child in right
						trav.right = newNode;
						break;
					}

				}
			}
		}

	}

	private void preorder(Node trav) {
		if (trav == null) {
			return;
		}
		System.out.print(trav.data + ", ");
		preorder(trav.left);
		preorder(trav.right);
	}

	public void preorder() {
		System.out.print("PRE : ");
		preorder(root);
		System.out.println();
	}

	private void inorder(Node trav) {
		if (trav == null) {
			return;
		}
		inorder(trav.left);
		System.out.print(trav.data + ", ");
		inorder(trav.right);
	}

	public void inorder() {
		System.out.print("IN : ");
		inorder(root);
		System.out.println();
	}

//	private void postorder(Node trav) {
//		if (trav == null) {
//			return;
//		}
//		postorder(trav.left);
//		postorder(trav.right);
//		System.out.print(trav.data + ", ");
//	}

//	public void postorder() {
//		System.out.print("POst : ");
//		postorder(root);
//		System.out.println();
//	}

	private void deleteAll(Node trav) {
		if (trav == null) {
			return;
		}
		deleteAll(trav.left);
		deleteAll(trav.right);
		trav.left = null;
		trav.right = null;
		trav = null;

	}

	public void deleteAll() {
		deleteAll(root);
		root = null;
	}

	public int height(Node trav) {
		if (trav == null)
			return -1;
		int hl = height(trav.left);
		int hr = height(trav.right);
		int max = hl > hr ? hl : hr;
		return max + 1;
	}

	public int height() {
		return height(root);

	}

	public void preorderNonRecursive() {
		Stack<Node> s = new Stack<>();
		Node trav = root;

		System.out.print("PRE :");
		while (trav != null || !s.isEmpty()) {

			while (trav != null) {
				System.out.print(trav.data + ", ");
				if (trav.right != null)
					s.push(trav.right);
				trav = trav.left;
			}
			if ((!s.isEmpty())) {
				trav = s.pop();
			}

		}
		System.out.println();
	}

	public void inorderNonRecursive() {
		System.out.print("IN :");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if ((!s.isEmpty())) {
				trav = s.pop();
				System.out.print(trav.data + ", ");
				trav = trav.right;
			}

		}
		System.out.println();
	}

	// Breadth First Search
	public Node bfs(int key) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node trav = q.poll();
			if (key == trav.data)
				return trav;
			if (trav.left != null)
				q.offer(trav.left);
			if (trav.right != null)
				q.offer(trav.right);
		}
		return null;
	}

	// Depth First Search
	public Node dfs(int key) {
		Stack<Node> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			Node trav = s.pop();
			if (key == trav.data)
				return trav;
			// we can push trav.right first and left.right second still it works+
			if (trav.left != null)
				s.push(trav.left);
			if (trav.right != null)
				s.push(trav.right);

		}
		return null;
	}

	// Binary Search => efficient than BFS & DFS
	public Node binarySearch(int key) {
		Node trav = root;
		while (trav != null) {
			if (key == trav.data)
				return trav;
			if (key < trav.data)
				trav = trav.left;
			else// key > trav.right
				trav = trav.right;
		}
		return null;
	}

	public Node[] binSearchWithParent(int key) {
		Node trav = root;
		Node parent = null;
		while (trav != null) {
			if (key == trav.data)
				return new Node[] { trav, parent };
			parent = trav;
			if (key < trav.data)
				trav = trav.left;
			else// key > trav.right
				trav = trav.right;
		}
		return new Node[] { null, null };
	}
/*
	public void delete(int val) {
		Node trav, parent;
		// find the Node to be deleted along wiht its parent
		Node[] arr = binSearchWithParent(val);
		trav = arr[0];
		parent = arr[1];
		// if node is not found ,throw the exception
		if (trav == null)
			throw new RuntimeException("Node not found ");
		// if node has left as well as right child
		if (trav.left != null && trav.right != null) {
			// find its successor with its parent
			parent = trav;
			Node succ = trav.right;
			while (succ.left != null) {
				parent = trav;
				succ = succ.left;
			}
			// overwrite data of node with successor data
			trav.data = succ.data;
			// mark successor node to be deleted
			trav = succ;
			
		}
		// if node has right child(or node doesn't have left child)
		if (trav.left == null) {
			if (trav == root)
				root = trav.right;
			else if (trav == parent.left)
				parent.left = trav.right;
			else
				parent.right = trav.right;
		}
		// if node has left child(or node doesn't have right child)
		else if (trav.right == null) {
			if (trav == root)
				root = trav.left;
			else if (trav == parent.left)
				parent.left = trav.left;
			else
				parent.right = trav.left;
		}
	}
	*/
	
	/* Ghule sir's code for delete node operation */
	public void delete(int val) {
		Node trav, parent;
		// find the node to be deleted along with its parent
		Node[] arr = binSearchWithParent(val);
		trav = arr[0];
		parent = arr[1];
		// if node is not found, throw the exception
		if(trav == null)
			throw new RuntimeException("Node not found.");
		// if node has left as well as right child
		if(trav.left != null && trav.right != null) {
			// find its successor with its parent
			parent = trav;
			Node succ = trav.right;
			while(succ.left != null) {
				parent = succ;
				succ = succ.left;
			}
			// overwrite data of node with successor data
			trav.data = succ.data;
			// mark successor node to be deleted
			trav = succ;
		}
		// if node has right child (or node doesn't have left child)
		if(trav.left == null) {
			if(trav == root)
				root = trav.right;
			else if(trav == parent.left)
				parent.left = trav.right;
			else
				parent.right = trav.right;
		}
		// if node has left child (or node doesn't have right child)
		else if(trav.right == null) {
			if(trav == root)
				root = trav.left;
			else if(trav == parent.left)
				parent.left = trav.left;
			else
				parent.right = trav.left;			
		}
	}
}

public class BSTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(50);
		bst.add(30);
		bst.add(10);
		bst.add(90);
		bst.add(100);
		bst.add(40);
		bst.add(70);
		bst.add(80);
		bst.add(60);
		bst.add(20);

		// bst.preorder();
		/*
		 * bst.preorderNonRecursive();
		 * 
		 * System.out.println(); // bst.inorderNonRecursive(); //
		 * System.out.println(" Height : "+bst.height()); // bst.deleteAll();// all node
		 * of BST is deleted // bst.inorder(); // bst.postorder(); //
		 * System.out.println(" Height : "+bst.height());
		 * System.out.println("Enter Element to Find  :"); int key = sc.nextInt(); Node
		 * temp = bst.bfs(key);
		 * 
		 * if (temp == null) { System.out.println("BFS : not found "); } else {
		 * System.out.println("BFS : found : " + temp.getData()); }
		 * System.out.println("***************************************"); temp =
		 * bst.dfs(key);
		 * 
		 * if (temp == null) { System.out.println("DFS : not found "); } else {
		 * System.out.println("DFS : found : " + temp.getData()); } temp =
		 * bst.binarySearch(key);
		 * 
		 * if (temp == null) { System.out.println("BS : not found "); } else {
		 * System.out.println("BS : found : " + temp.getData()); } Node arr[] =
		 * bst.binSearchWithParent(key);
		 * 
		 * if (arr[0] == null) { System.out.println("BS : not found "); } else if(arr[1]
		 * == null) System.out.println("BS : found : " +
		 * arr[0].getData()+"  root node");
		 * 
		 * else { System.out.println("BS : found : " +
		 * arr[0].getData()+"  with_Parent  "+arr[1].getData());
		 * 
		 * }
		 */

		bst.inorder();
try {
		System.out.println("Enter element to delete :");
		int val = sc.nextInt();
		bst.delete(val);
}catch (Exception e)
{
	System.out.println(e.getMessage());
}
		bst.inorder();

	}
}
