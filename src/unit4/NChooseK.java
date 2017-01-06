package unit4;
import java.util.Scanner;

public class NChooseK {

	public static void main(String[] args) {
		NChooseK nck = new NChooseK();
		
		try(Scanner sc = new Scanner(System.in);){
			System.out.println("Enter the value of n: ");
			int n = sc.nextInt();
			System.out.println("Enter the value of k: ");
			int k = sc.nextInt();
			long result = nck.calculateNChooseK(n, k);
			System.out.println(n+" Choose "+k+" is "+ result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public long calculateNChooseK(int n, int k){
		if(n == k)
			return (long)1;
		
		if(k == 1)
			return (long)n;

		return (long)calculateNChooseK(n-1, k-1) + (long)calculateNChooseK(n-1, k);
	}	
	
}
