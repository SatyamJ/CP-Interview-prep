package unit3;

import java.util.ArrayList;

public class StackNode {
	TreeNode<Integer> tNode;
	ArrayList<Integer> path;
	int distance;
	StackNode next;
	
	public StackNode(TreeNode<Integer> tNode){
		this.tNode = tNode;
		path = new ArrayList<Integer>();
		distance = 0;
		next = null;
	}
}
