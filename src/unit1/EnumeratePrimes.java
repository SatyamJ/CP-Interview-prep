package unit1;

import java.util.Scanner;

public class EnumeratePrimes {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int n = sc.nextInt();
		
		EnumeratePrimes e = new EnumeratePrimes();
		int[] arr = e.findPrimes(n);
		e.display(arr);
		sc.close();
	}
	
	public int[] findPrimes(int n){
		int count = 0;
		boolean isPrime = false;
		for(int i=2; i<=n; i++){
			isPrime = true;
			for(int j=2; j<=i/2; j++){
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime)
				count++;
		}
		
		int[] primes = new int[count];
		int index = 0;
		for(int i=2; i<=n; i++){
			isPrime = true;
			for(int j=2; j<=i/2; j++){
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime)
				primes[index++] = i;
		}
		
		return primes;
	}
	
	public void display(int[] arr){
		System.out.println("Elements of the array are: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
