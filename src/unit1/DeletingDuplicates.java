package unit1;

import java.util.Scanner;

public class DeletingDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		DeletingDuplicates d = new DeletingDuplicates();
		d.takeSortedInput(arr);
		int distinctCount = d.deleteDuplicates(arr);
		System.out.println("Number of distinct elements: "+ distinctCount);
		d.display(arr);	
		sc.close();
	}
	
	public void takeSortedInput(int[] arr){
		System.out.println("enter the elements of the array: ");
		Scanner sc = new Scanner(System.in);
		arr[0] = sc.nextInt();
		int focus = arr[0];
		
		for(int i=1; i<arr.length; i++){
			int current = sc.nextInt();
			if(current < focus){
				System.out.println("We need sorted array. Please try again");
				i--;
			}else{
				arr[i] = current;
				focus = current;
			}
		}
		
		sc.close();
	}
	
	public void display(int[] arr){
		System.out.print("Elements of the array are: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public int deleteDuplicates(int[] arr){
		int focus = 0;
		int i;
		int count = 1;
		for(i=1; i<arr.length; i++){
			if(arr[i] != arr[focus]){
				arr[++focus] = arr[i];
				count++;
			}
		}
		
		if(focus != arr.length-1){
			for(int j=focus+1; j<arr.length; j++)
				arr[j] = 0;
		}
		
		return count;
	}

}
