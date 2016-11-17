package unit2;

public class LinkedListNodeImp<E> implements LinkedListNode<E>{
	
	private E value;
	private LinkedListNodeImp<E> next;
	
	public LinkedListNodeImp(){
		this.value = null;
		this.next = null;
	}
	
	public LinkedListNodeImp(E value){
		this.value = value;
		this.next = null;
	}
	
	/* getter/setter for this node's value */
    public E getValue(){
    	return this.value;
    }
    
    public void setValue(E value){
    	this.value = value;
    }

    /* getter/setter for the subsequent node, or null if this is the last node */
    
    public LinkedListNodeImp<E> getNext(){
    	if(this.next == null)
    		return null;
    	else
    		return this.next;
    }
    
    public void setNext(LinkedListNode<E> next){
    	this.next = (LinkedListNodeImp<E>) next;
    }

    /**
     * Initialize this node and all of its subsequent nodes from
     * an array of values, starting with the head value at index 0
     *
     * @param listValues - the ordered values for the whole list
     */
    public void setValuesFromArray(E[] listValues){
    	this.value = listValues[0];
    	LinkedListNodeImp<E> current = this;
    	
    	for(int i=1; i<listValues.length; i++){
    		LinkedListNodeImp<E> newNode = new LinkedListNodeImp<E>(listValues[i]);
    		current.setNext(newNode);
    		current = newNode;
    	}
    }
    
    public void display(){
    	System.out.print(this.getValue());
    	LinkedListNodeImp<E> current = (LinkedListNodeImp<E>) this.getNext();
    	while(current != null){
    		System.out.print("->"+current.getValue());
    		current = (LinkedListNodeImp<E>) current.getNext();
    	}
    }
}
