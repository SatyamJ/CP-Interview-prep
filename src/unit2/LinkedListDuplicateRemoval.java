package unit2;

import  java.util.HashMap;

public class LinkedListDuplicateRemoval {

	public static void main(String[] args) {
		
		Integer[] arr1 = new Integer[] {5, 7, 10, 5, 11, 7, 7};
//		Integer[] initArr = new Integer[] {5, 7, 10};
		
		LinkedListNodeImp<Integer> ll1 = new LinkedListNodeImp<Integer>();
		ll1.setValuesFromArray(arr1);
		System.out.println("Linked list 1:");
		ll1.display();
		
		LinkedListDuplicateRemoval dr = new LinkedListDuplicateRemoval();
		
		dr.removeDuplicates(ll1);
		System.out.println("\nLinked List without duplicates using no buffer:");
		ll1.display();
		
		Integer[] arr2 = new Integer[] {7, 7, 7, 7};
		LinkedListNodeImp<Integer> ll2 = new LinkedListNodeImp<Integer>();
		ll2.setValuesFromArray(arr2);
		System.out.println("\nLinked list 2:");
		ll2.display();
		
		dr.removeDuplicatesUsingBuffer(ll2);
		System.out.println("\nLinked List without duplicates using buffer:");
		ll2.display();
	}

	public void removeDuplicates(LinkedListNodeImp<Integer> ll){
		
		if(ll != null){
			LinkedListNodeImp<Integer> focus = ll;
			
			while(focus.getNext() != null){
				LinkedListNodeImp<Integer> current = focus;
				while(current.getNext() != null){
					if(current.getNext().getValue().intValue() == focus.getValue().intValue()){
						current.setNext(current.getNext().getNext());
					}else{
						current = current.getNext();
					}
				}
				
				if(focus.getNext() == null)
					break;
				else
					focus = focus.getNext();
			}
		}
	}
	
	public void removeDuplicatesUsingBuffer(LinkedListNodeImp<Integer> ll){
		HashMap<Integer, Boolean> buffer = new HashMap<Integer, Boolean>();
		
		LinkedListNodeImp<Integer> focus = ll;
		buffer.put(focus.getValue(), true);
		
		while(focus.getNext() != null){
			if(buffer.containsKey(focus.getNext().getValue())){
				focus.setNext(focus.getNext().getNext());
			}else{
				buffer.put(focus.getNext().getValue(), true);
				
				if(focus.getNext() == null)
					break;
				else
					focus = focus.getNext();
			}
		}
	}
}
