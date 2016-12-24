package unit3;
import unit2.LinkedListNodeImp;

public class LinkedList<E> {
	
	public LinkedListNodeImp<E> head;
	public LinkedListNodeImp<E> tail;
	public int length;
	
	public LinkedList(){
		head = null;
		tail = null;
		length = 0;
	}
	
	public void add(E value){
		LinkedListNodeImp<E> node = new LinkedListNodeImp<E>(value);
		if(head == null){
			head = tail = node;
			length = 1;
		}else{
			tail.setNext(node);
			tail = tail.getNext();
			length++;
		}
	}
	
	public void printLinkedList(){
		System.out.print(head.getValue().toString());
		LinkedListNodeImp<E> current = head.getNext();
		
		while(current != null){
			System.out.print(" -> "+current.getValue().toString());
			current = current.getNext();
		}
	}
	
	/*
	 * Test:
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(new Integer(1));
		ll.add(new Integer(2));
		ll.add(new Integer(3));
		ll.add(new Integer(4));
		ll.add(new Integer(5));
		ll.add(new Integer(6));
		ll.add(new Integer(7));
		
		ll.printLinkedList();
	}
	*/
}
