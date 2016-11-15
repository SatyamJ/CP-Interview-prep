package unit2;

public class LinkedListAddNumbers {

	public static void main(String[] args) {
		
		int a = 9999;
		int b = 9999;
		
		LinkedListAddNumbers l = new LinkedListAddNumbers();
		LinkedListNodeImp<Integer> operand1 = l.createNumberLl(a);
		LinkedListNodeImp<Integer> operand2 = l.createNumberLl(b);
		
		operand1.display();
		System.out.println();
		operand2.display();
		System.out.println();
		
		
		LinkedListNodeImp<Integer> sum = l.add(operand1, operand2);
		sum.display();
	}

	public LinkedListNodeImp<Integer> add(LinkedListNodeImp<Integer> operand1, LinkedListNodeImp<Integer> operand2){			
		LinkedListNodeImp<Integer> sum = new LinkedListNodeImp<Integer>();
		LinkedListNodeImp<Integer> current = sum;
		int carry = 0;
		
		while(operand1!=null || operand2!=null){
			
			int temp = 0;
			
			if(operand1 == null){
				temp = operand2.getValue().intValue() + carry;
				operand2 = (LinkedListNodeImp<Integer>) operand2.getNext();
			}else if(operand2 == null){
				temp = operand1.getValue().intValue() + carry;
				operand1 = (LinkedListNodeImp<Integer>) operand1.getNext();
			}else{
				temp = operand1.getValue().intValue() + operand2.getValue().intValue() + carry;
				operand1 = (LinkedListNodeImp<Integer>) operand1.getNext();
				operand2 = (LinkedListNodeImp<Integer>) operand2.getNext();				
			}
			
			carry = temp / 10;
			temp = temp % 10;
			
			if(current.getValue() == null){
				current.setValue(new Integer(temp));
			}else{
				LinkedListNodeImp<Integer> next = new LinkedListNodeImp<Integer>(new Integer(temp));
				current.setNext(next);
				current = (LinkedListNodeImp<Integer>) current.getNext();
			}
				
		}
		
		if(carry != 0){
			LinkedListNodeImp<Integer> next = new LinkedListNodeImp<Integer>(new Integer(carry));
			current.setNext(next);
			current = (LinkedListNodeImp<Integer>) current.getNext();
		}
		
		return sum;
	}
	
	public LinkedListNodeImp<Integer> createNumberLl(int n){
		int num = n;
		
		LinkedListNodeImp<Integer> llNumber = new LinkedListNodeImp<Integer>();
		LinkedListNodeImp<Integer> current = llNumber;
		
		while(num/10 != 0){
			int digit = num % 10;
			
			if(llNumber.getValue() == null){
				llNumber.setValue(new Integer(digit));
				current = llNumber;
			}
			else{
				LinkedListNodeImp<Integer> newDigit = new LinkedListNodeImp<Integer>(new Integer(digit));
				current.setNext(newDigit);
				current = newDigit;
			}
			
			num = num/10;
		}
		
		LinkedListNodeImp<Integer> newDigit = new LinkedListNodeImp<Integer>(new Integer(num));
		current.setNext(newDigit);
		return llNumber;
	}
}
