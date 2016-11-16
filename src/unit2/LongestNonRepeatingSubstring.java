package unit2;

import java.util.HashMap;

public class LongestNonRepeatingSubstring {

	public static void main(String[] args) {
		
		String str = "abcabcdbb";
//		String str = "abc";
		LongestNonRepeatingSubstring l = new LongestNonRepeatingSubstring();
		System.out.println(l.findLength(str));
	}
	
	public int findLength(String s){
		
		int n = s.length();
		int maxLength = 1;
		
		if(n == 0)
			return 0;
		else if(n == 1)
			return maxLength;
		else{
			HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
			int currentLength = 1;
			
			for(int i=0; i<n-1; i++){
				letterCount.clear();
				char startChar = s.charAt(i);
				letterCount.put(new Character(startChar), new Integer(1));
				currentLength = 1;
				
				for(int j=i+1; j<n; j++){
					Character focus = s.charAt(j);
					if(letterCount.containsKey(focus)){
						if(currentLength > maxLength)
							maxLength = currentLength;
						break;
					}else{
						letterCount.put(focus, new Integer(1));
						currentLength += 1;
					}
				}
				
				if(currentLength > maxLength)
					maxLength = currentLength;
			}
		}
		return maxLength;
	}
}
