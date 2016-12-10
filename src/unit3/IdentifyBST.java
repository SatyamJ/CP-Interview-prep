package unit3;

public class IdentifyBST {

	private static int index = 0;
	private static int size = 0;
	
	public static void main(String[] args) {
		
		IdentifyBST i = new IdentifyBST();
		
		TreeNode<Integer> treeRoot = i.createTree();
		
		i.updateTreeSize(treeRoot);
		int[] arr = new int[size];
		i.putInArrayInorder(treeRoot, arr);
		
		if(i.checkforBST(arr))
			System.out.println("The given tree is a BST");
		else
			System.out.println("The given tree is not a BST");
		
	}
	
	public TreeNode<Integer> createTree(){
		TreeNode<Integer> root = new TreeNode<Integer>(new Integer(20));
		root.addLeftChild(new TreeNode<Integer>(new Integer(7)));
		root.addRightChild(new TreeNode<Integer>(new Integer(46)));
		
		root.left.addRightChild(new TreeNode<Integer>(new Integer(18)));
		root.left.right.addLeftChild(new TreeNode<Integer>(new Integer(16)));
		
		return root;
	}
	
	public void putInArrayInorder(TreeNode<Integer> node, int[] arr){
		if(node == null)
			return;
		else{
			putInArrayInorder(node.left, arr);
			arr[index++] = node.value.intValue();
			putInArrayInorder(node.right, arr);
		}
	}
	
	public boolean checkforBST(int[] arr){
		
		boolean isBST = true;
		if(arr.length > 1){
			for(int i=1; i<arr.length; i++){
				if(arr[i]<arr[i-1]){
					isBST = false;
					break;
				}
			}
		}
		
		return isBST;
	}
	
	public void updateTreeSize(TreeNode<Integer> node){
		if(node == null)
			return;
		else{
			updateTreeSize(node.left);
			size++;
			updateTreeSize(node.right);
		}
	}

}
