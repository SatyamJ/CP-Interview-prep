package unit3;

import unit2.LinkedListNodeImp;

public class BalancedBSTFromLL {
	
	TreeNode<Integer> treeRoot;
	LinkedListNodeImp<Integer> head;
	
	public BalancedBSTFromLL(){
		treeRoot = null;
	}
	
	public TreeNode<Integer> createBalancedBSTFromLL(int n){
		if(n < 1)
			return null;
		
		TreeNode<Integer> leftChild = createBalancedBSTFromLL(n/2);
		TreeNode<Integer> root = new TreeNode<Integer>(head.getValue());
		head = head.getNext();
		root.left = leftChild;
		root.right = createBalancedBSTFromLL(n - n/2 - 1);
		
		return root;
	}
	
	public void inOrderTraversal(TreeNode<Integer> node){
		if(node == null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.value.toString() + " ");
		inOrderTraversal(node.right);
	}
	
	public int isBalanced(TreeNode<Integer> node){
		if(node == null)
			return 0;
		
		int leftSubTreeHeight = isBalanced(node.left);
		if(leftSubTreeHeight < 0)
			return -1;
		
		int rightSubTreeHeight = isBalanced(node.right);
		if(rightSubTreeHeight < 0)
			return -1;
		
		if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1)
			return -1;
		else
			return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(new Integer(1));
		ll.add(new Integer(2));
		ll.add(new Integer(3));
		ll.add(new Integer(4));
		ll.add(new Integer(5));
		ll.add(new Integer(6));
		ll.add(new Integer(7));
		ll.add(new Integer(8));
		
//		ll.printLinkedList();
		
		BalancedBSTFromLL b = new BalancedBSTFromLL();
		b.head = ll.head;
		b.treeRoot = b.createBalancedBSTFromLL(ll.length);
		b.inOrderTraversal(b.treeRoot);
		System.out.println();
		
		int treeHeight = b.isBalanced(b.treeRoot);
		if( treeHeight< 0)
			System.out.println("The BST is not balanced");
		else
			System.out.println("The BST is balanced with height = "+treeHeight);
	}

}
