package unit4;
import java.util.Scanner;
import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		
		Factorial f = new Factorial();
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a positive integer: ");
		String input = console.next();
		BigInteger inputBI = new BigInteger(input);
		
		while(inputBI.compareTo(BigInteger.valueOf(0)) != 1){
			System.out.println("Input is not a positive integer. Try again. ");
			input = console.next();
			inputBI = new BigInteger(input);
		}
		System.out.printf("Factorial of %d is %d", inputBI, f.computeFactorial(inputBI));
		console.close();
	}
	
	public BigInteger computeFactorial(BigInteger n){
		
		if(n.equals(BigInteger.valueOf(1)))
			return BigInteger.valueOf(1);
		else
			return n.multiply(computeFactorial(n.subtract(BigInteger.valueOf(1))));
	}

}
