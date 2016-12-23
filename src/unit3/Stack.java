package unit3;

public class Stack {
	
	StackNode top;
	
	public Stack(){
		top = null;
	}
	
	public void push(StackNode node){
		if(top == null)
			top = node;
		else{
			node.next = top;
			top = node;
		}
	}
	
	public StackNode pop(){
		if(top == null){
			System.out.println("Stack underflow.");
			return null;
		}else{
			StackNode node = top;
			top = top.next;
			return node;
		}
	}
	
	public StackNode peek(){
		if(top == null){
			System.out.println("Stack is empty.");
			return null;
		}else{
			return top;
		}
	}
	
	public boolean isEmpty(){
		if(top == null)
			return true;
		else
			return false;
	}
}
