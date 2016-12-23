package unit3;

import java.util.ArrayList;
import java.util.Iterator;

public class PathSumDFS {

	public static int leafCount = 0;
	public static void main(String[] args) {
		
		PathSumDFS p = new PathSumDFS();
		BinarySearchTree bst = p.createBST();
		
		p.countLeafNodes(bst.getRootNode());
		int[][] paths = new int[leafCount][];

		int target = 33;
		p.findPaths(bst.getRootNode(), paths, target);
		
		p.printPaths(paths);
	}
	
	public void printPaths(int arr[][]){
		for(int i=0;i<arr.length;i++){
			if(arr[i] != null){
				System.out.print(arr[i][0]);
				for(int j=1; j<arr[i].length; j++)
					System.out.print(" -> "+arr[i][j]);
				System.out.println();
			}
				
		}
	}
	
	public BinarySearchTree createBST(){
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(10);
		bst.addNode(9);
		bst.addNode(12);
		bst.addNode(8);
		bst.addNode(6);
		bst.addNode(11);
		bst.addNode(15);
		bst.addNode(13);
		
		return bst;
	}
	
	public void countLeafNodes(TreeNode<Integer> node){
		if(node == null)
			return;
		
		countLeafNodes(node.left);
		if(node.left==null && node.right==null)
			leafCount++;
		countLeafNodes(node.right);
	}
	
	public void findPaths(TreeNode<Integer> tNode, int[][] paths, int target){
		 
		int index = 0;
		Stack stack = new Stack();
		StackNode sNode = new StackNode(tNode);
		sNode.distance = tNode.value.intValue();
		sNode.path.add(new Integer(tNode.value.intValue()));
		stack.push(sNode);
		
		while(!stack.isEmpty()){
			StackNode focus = stack.pop();
			
			if(focus.tNode.left==null && focus.tNode.right==null){
				if(focus.distance == target){
					copyToArray(focus.path, paths, index++);
				}
			}else{
				if(focus.tNode.left != null){
					StackNode sLNode = new StackNode(focus.tNode.left);
					sLNode.distance = focus.distance + sLNode.tNode.value.intValue();
					Iterator<Integer> itr = focus.path.iterator();
					while(itr.hasNext()){
						sLNode.path.add(itr.next());
					}
					
					sLNode.path.add(sLNode.tNode.value.intValue());
					stack.push(sLNode);
				}
				
				if(focus.tNode.right != null){
					StackNode sRNode = new StackNode(focus.tNode.right);
					sRNode.distance = focus.distance + sRNode.tNode.value.intValue();
					Iterator<Integer> itr = focus.path.iterator();
					while(itr.hasNext()){
						sRNode.path.add(itr.next());
					}
					sRNode.path.add(sRNode.tNode.value.intValue());
					stack.push(sRNode);
				}
			}
		}
	}
	

	public int findArraySum(ArrayList<Integer> arrList) {
		int sum = 0;
		
		Iterator<Integer> itr = arrList.iterator();
		
		while(itr.hasNext()){
			sum += itr.next().intValue();
		}
		return sum;
	}
	
	public void copyToArray(ArrayList<Integer> al, int arr[][], int index){

		Iterator<Integer> itr = al.iterator();
		int[] temp = new int[al.size()];
		int i = 0;
		while(itr.hasNext()){
			temp[i++] = itr.next().intValue();
		}
		
		arr[index] = temp;
	}
}

