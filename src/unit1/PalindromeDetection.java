package unit1;

public class PalindromeDetection {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		PalindromeDetection p = new PalindromeDetection();
		if(p.isPalindrome(str))
			System.out.println("The entered string is palindrome");
		else
			System.out.println("The entered string is not a palindrome");

	}
	
	public boolean isPalindrome(String input){
		boolean palindrome = true;
		int n = input.length();
		int front = 0;
		int rear = n-1;
		
		while(front<rear){
			while(!((input.charAt(front)>='0' && input.charAt(front)<='9') || (input.charAt(front)>='a' && input.charAt(front)<='z') || (input.charAt(front)>='A' && input.charAt(front)<='Z')))
				front++;
			
			while(!((input.charAt(rear)>='0' && input.charAt(rear)<='9') || (input.charAt(rear)>='a' && input.charAt(rear)<='z') || (input.charAt(rear)>='A' && input.charAt(rear)<='Z')))
				rear--;
			
			if(front<rear){
				if(Character.toLowerCase(input.charAt(front)) == Character.toLowerCase(input.charAt(rear))){
					front++;
					rear--;
				}else{
					palindrome = false;
					break;
				}
			}else
				break;
		}
		
		return palindrome;
	}

}
