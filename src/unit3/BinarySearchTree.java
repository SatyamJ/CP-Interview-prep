package unit3;

public class BinarySearchTree {
	
	private TreeNode<Integer> root;
	
	public TreeNode<Integer> getRootNode(){
		return root;
	}
	
	public void addNode(int number){
		TreeNode<Integer> node = new TreeNode<Integer>(new Integer(number));
		
		if(root == null){
			root = node;
		}else{
			TreeNode<Integer> focus = root;
			TreeNode<Integer> parent = root;
			
			while(focus != null){
				parent = focus;
				if(node.value.intValue() < focus.value.intValue()){
					focus = focus.left;
				}else{
					focus = focus.right;
				}
			}
			
			if(node.value.intValue() < parent.value.intValue())
				parent.left = node;
			else
				parent.right = node;
		}
	}
	
	public boolean delete(int number){
		boolean deleted = false;
		
		if(root == null){
			System.out.println("Tree is empty. Node not found!");
			return false;
		}
		
		TreeNode<Integer> focus = root;
		TreeNode<Integer> parent = root;
		
		while(focus != null){
			if(focus.value.intValue() == number)
				break;
			else if(number < focus.value.intValue()){
				parent = focus;
				focus = focus.left;
			}else{
				parent = focus;
				focus = focus.right;
			}
		}
	
		if(focus == null){
			System.out.printf("Node with value %d not found.\n", number);
			return false;
		}
			
		
		if(focus.value.intValue() == number){
			System.out.printf("Node with value %d found. Deleting...\n", number);
			boolean focusIsLeftChild;
			if(parent.left == focus)
				focusIsLeftChild = true;
			else
				focusIsLeftChild = false;
			
			if(focus.left == null){
				if(focusIsLeftChild)
					parent.left = focus.right;
				else
					parent.right = focus.right;
			}else if(focus.right == null){
				if(focusIsLeftChild)
					parent.left = focus.left;
				else
					parent.right = focus.left;
			}else{
				TreeNode<Integer> replacement = findReplacement(focus);
				replaceNode(focus, parent, replacement);
				deleted = true;
			}
		}
		
		return deleted;
	}
	
	public TreeNode<Integer> findReplacement(TreeNode<Integer> node){
		TreeNode<Integer> parent = node;
		TreeNode<Integer> replacement = node.right;
		TreeNode<Integer> focus = replacement;
		
		while(focus != null){
			parent = replacement;
			replacement = focus;
			focus = focus.left;
		}
		
		if(replacement == node.right)
			parent.right = replacement.right;
		else
			parent.left = replacement.right;
		
		return replacement;
	}
	
	public void replaceNode(TreeNode<Integer> target, TreeNode<Integer> parent, TreeNode<Integer> replacement){
		replacement.left = target.left;
		
		if(replacement != target.right)
			replacement.right = target.right;
		
		if(target != root){
			if(parent.left == target){
				parent.left = replacement;
			}else{
				parent.right = replacement;
			}
		}
	}
	
	public void inOrderTraversal(TreeNode<Integer> node){
		if(node == null)
			return;
		else{
			inOrderTraversal(node.left);
			System.out.print(node.value.intValue()+" ");
			inOrderTraversal(node.right);
		}
	}
	
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(5);
		bst.addNode(4);
		bst.addNode(8);
		bst.addNode(11);
		bst.addNode(13);
		bst.addNode(4);
		bst.addNode(5);
		bst.addNode(1);
		bst.addNode(7);
		bst.addNode(2);
//		bst.addNode(9);
		
		bst.inOrderTraversal(bst.getRootNode());
		System.out.println();
		if(bst.delete(8))
			System.out.println("Node deleted.");
		bst.inOrderTraversal(bst.getRootNode());
	}
}
