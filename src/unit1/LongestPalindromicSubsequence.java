package unit1;
import java.util.Scanner;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.next();
		
//		String str = "abdbbbbdba";
		LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
		String lPSubstring = l.findLongestPalindromicSubstring(str);
		
		System.out.println(lPSubstring + " is longest panlindromic substring of " + str);
		
		sc.close();
	}
	
	public String findLongestPalindromicSubstring(String input){
		int start = 0;
		int n = input.length();
		int end = n-1;
		
//		StringBuffer substring = new StringBuffer(input.substring(0, 1));
		StringBuffer longest = new StringBuffer(input.substring(0, 1));
		
		for(int i=0; i<n-1; i++){
			start = i;
			end = n-1;
			
			while(start<end){
				if(input.charAt(start) == input.charAt(end)){
					if(isPalindrome(input, start, end)){
						if(longest.length() < (end-start+1)){
							longest = new StringBuffer(input.substring(start, end+1));
						}
					}
				}
				
				end--;
			}
		}
	
		return longest.toString();
	}
	
	public boolean isPalindrome(String str, int front, int rear){
		boolean palindrome = true;
		
		while(front<rear){
			if(str.charAt(front) == str.charAt(rear)){
				front++;
				rear--;
			}else{
				palindrome = false;
				break;
			}	
		}
		return palindrome;
	}

}
