package unit3;

class QueueTreeNode{
	int parentDistance;
	TreeNode<Integer> treeNode;
	QueueTreeNode next;
	
	public QueueTreeNode(TreeNode<Integer> treeNode){
		this.treeNode = treeNode;
		parentDistance = 0;
		next = null;
	}
}

public class Queue {
	
	QueueTreeNode head;
	QueueTreeNode tail;
	
	public Queue(){
		head = null;
		tail = null;
	}
	
	public void enqueue(QueueTreeNode node){
		if(head == null){
			head = node;
			tail = node;
		}else{
			tail.next = node;
			tail = node;
		}
	}
	
	public QueueTreeNode dequeue(){
		if(head == null){
			System.out.println("Invalid operation. Queue empty.");
			return null;
		}else if(head == tail){
			QueueTreeNode returnNode = head;
			head = tail = null;
			return returnNode;
		}else{
			QueueTreeNode returnNode = head;
			head = head.next;
			return returnNode;
		}
			
	}
	
	public boolean isEmpty(){
		if(head == null)
			return true;
		else
			return false;
	}
	
	public void display(){
		if(head == null)
			return;
		else if(head == tail)
			System.out.println(head.treeNode.value.intValue());
		else{
			QueueTreeNode current = head;
			while(current != tail){
				System.out.print(current.treeNode.value.intValue() + " -> ");
				current = current.next;
			}
			System.out.print(tail.treeNode.value.intValue());
		}
	}
	
	/*
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(new QueueTreeNode(new Integer(5)));
		q.enqueue(new QueueTreeNode(new Integer(15)));
		q.enqueue(new QueueTreeNode(new Integer(90)));
		q.enqueue(new QueueTreeNode(new Integer(45)));
		q.dequeue();
		q.enqueue(new QueueTreeNode(new Integer(36)));
		q.display();
	}
	*/
}
