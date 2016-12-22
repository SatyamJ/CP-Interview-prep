package unit4;
import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		GCD g = new GCD();
		
		System.out.println("Choose an option:\n1. Calculate GCD of two numbers.\n2. Calculate GCD of array of numbers.");
		int option = console.nextInt();
		
		while(true){
			if(option == 1){
				g.twoNumbers();
				break;
			}else if(option == 2){
				g.arrayOfNumbers();
				break;
			}else{
				System.out.println("Invalid input. Try again");
				option = console.nextInt();
			}
		}
		
		console.close();
	}
	
	public void twoNumbers(){
		int first = takeInput();
		int second = takeInput();
		System.out.println("GCD of two numbers is "+ computeGCDTwoNumbers(first, second));
	}
	
	public void arrayOfNumbers(){
		Scanner console = new Scanner(System.in);
		System.out.print("What's the size of the array?");
		int size = takeInput();
		
		int[] arr = new int[size];
		System.out.println("Now enter the elements of the array.");
		for(int i=0; i<size; i++){
			arr[i] = takeInput();
		}
		
		System.out.println("GCD of the array is "+ computeGCDArray(arr));
		
		console.close();
	}
	
	public int takeInput(){
		Scanner console = new Scanner(System.in);
		System.out.print("\nEnter a positive integer: ");
		int input = console.nextInt();
		
		while(input<=0){
			System.out.print("\nEntered input is not a positive integer. Try again: ");
			input = console.nextInt();
		}
		
		console.close();
		return input;
	}

	public int computeGCDTwoNumbers(int a, int b){
		if(a == 0 || b == 0)
			return a+b;
		else
			return computeGCDTwoNumbers(b, a%b);
	}
	
	public int computeGCDArray(int[] arr){
		
		int gcd = arr[0];
		if(arr.length == 1)
			return gcd;
		else{
			for(int i=1; i<arr.length; i++){
				gcd = computeGCDTwoNumbers(gcd, arr[i]);
			}
		}
		return gcd;
	}
}
