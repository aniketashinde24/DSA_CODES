
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

	private void postorder(Node trav) {
		if (trav == null) {
			return;
		}
		postorder(trav.left);
		postorder(trav.right);
		System.out.print(trav.data + ", ");
	}

	public void postorder() {
		System.out.print("POst : ");
		postorder(root);
		System.out.println();
	}

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

}

public class BSTreeMain {

	public static void main(String[] args) {

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

		bst.preorder();
		System.out.println(" Height : "+bst.height());
		bst.deleteAll();// all node of BST is deleted
		bst.inorder();
		bst.postorder();
		System.out.println(" Height : "+bst.height());


	}
}
