package unit3;

public class CountLeafNodes {

	private static int count = 0;
	public static void main(String[] args) {
		
		CountLeafNodes c = new CountLeafNodes();
		TreeNode<Integer> root = c.createTree();
		c.leafCountWithInorder(root);
		System.out.println("Number of leaf nodes in the tree is "+count);
	}
	
	public TreeNode<Integer> createTree(){
		TreeNode<Integer> root = new TreeNode<Integer>(new Integer(20));
		root.addLeftChild(new TreeNode<Integer>(new Integer(7)));
		root.addRightChild(new TreeNode<Integer>(new Integer(46)));
		
		root.left.addRightChild(new TreeNode<Integer>(new Integer(18)));
		root.left.right.addLeftChild(new TreeNode<Integer>(new Integer(16)));
		
		return root;
	}
	
	public void leafCountWithInorder(TreeNode<Integer> node){
		if(node == null){
			return;
		}else{
			leafCountWithInorder(node.left);
			if(node.left == null && node.right == null)
				count++;
			leafCountWithInorder(node.right);
		}
	}

}
