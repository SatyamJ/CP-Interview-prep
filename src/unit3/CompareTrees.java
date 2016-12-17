package unit3;

public class CompareTrees {

	public static void main(String[] args) {
		CompareTrees c = new CompareTrees(); 
		TreeNode<Integer> t1 = c.createTree();
		TreeNode<Integer> t2 = c.createTree();
		
		if(c.isEqual(t1, t2))
			System.out.println("Both trees are equal");
		else
			System.out.println("The trees are not equal");
	}
	
	public TreeNode<Integer> createTree(){
		TreeNode<Integer> root = new TreeNode<Integer>(new Integer(20));
		root.addLeftChild(new TreeNode<Integer>(new Integer(7)));
		root.addRightChild(new TreeNode<Integer>(new Integer(46)));
		
		root.left.addRightChild(new TreeNode<Integer>(new Integer(18)));
		root.left.right.addLeftChild(new TreeNode<Integer>(new Integer(16)));
		
		return root;
	}
	
	public boolean isEqual(TreeNode<Integer> node1, TreeNode<Integer> node2){
		
		if(node1==null && node2==null)
			return true;
		else if(node1!=null && node2!=null){
			return (node1.value.intValue() == node2.value.intValue()) && (isEqual(node1.left, node2.left)) && (isEqual(node1.right, node2.right));
		}
		
		return false;
	}
}
