package unit3;

public class TreeNode<E> {
	E value;
	TreeNode<E> left, right;
	
	public TreeNode(E value){
		this.value = value;
		this.left = this.right = null;
	}
	
	public void addLeftChild(TreeNode<E> node){
		if(this.left == null)
			this.left = node;
		else
			System.out.println("Can't add. Node's left child position is filled.");
	}
	
	public void addRightChild(TreeNode<E> node){
		if(this.right == null)
			this.right = node;
		else
			System.out.println("Can't add. Node's right child position is filled.");
	}
}
