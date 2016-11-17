package unit3;

public class TreeNode<E> {
	E value;
	TreeNode<E> left, right;
	
	public TreeNode(E value){
		this.value = value;
		this.left = this.right = null;
	}
}
