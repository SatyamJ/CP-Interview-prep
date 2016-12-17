package unit3;

import java.util.Scanner;

public class PathSumBFS {

	public static void main(String[] args) {
		PathSumBFS p = new PathSumBFS();
		TreeNode<Integer> treeRoot = p.createTree();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the target value: ");
		int target = sc.nextInt();
		
		if(p.pathExistsWithTarget(treeRoot, target))
			System.out.println("Path with target value exists");
		else
			System.out.println("Path with target value does not exist");
		
		sc.close();
	}
	
	public boolean pathExistsWithTarget(TreeNode<Integer> node, int target){
		boolean exists = false;
		
		Queue q = new Queue();
		q.enqueue(new QueueTreeNode(node));
		
		while(! q.isEmpty()){
			
			QueueTreeNode current = q.dequeue();
			if(current.treeNode.value.intValue() + current.parentDistance == target)
				return true;
			else{
				if(current.treeNode.left != null){
					QueueTreeNode leftChild = new QueueTreeNode(current.treeNode.left);
					leftChild.parentDistance = current.parentDistance + current.treeNode.value.intValue();
					q.enqueue(leftChild);
				}
				
				if(current.treeNode.right != null){
					QueueTreeNode rightChild = new QueueTreeNode(current.treeNode.right);
					rightChild.parentDistance = current.parentDistance + current.treeNode.value.intValue();
					q.enqueue(rightChild);
				}
			}
			
		}
		return exists;
	}
	
	public TreeNode<Integer> createTree(){
		TreeNode<Integer> root = new TreeNode<Integer>(new Integer(20));
		root.addLeftChild(new TreeNode<Integer>(new Integer(7)));
		root.addRightChild(new TreeNode<Integer>(new Integer(46)));
		
		root.left.addRightChild(new TreeNode<Integer>(new Integer(18)));
		root.left.right.addLeftChild(new TreeNode<Integer>(new Integer(16)));
		
		return root;
	}

}
