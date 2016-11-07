package unit1;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] arr = {"bceefgh", "bceghijk", "bcefgh"};
		
		LongestCommonPrefix l = new LongestCommonPrefix();
		String lcp = l.findLongestCommonPrefix(arr);
		
		System.out.println("Longest common prefix is: "+ lcp);
	}
	
	public String findLongestCommonPrefix(String[] strArr){
		
		StringBuffer longestPrefix = new StringBuffer();
		int index = 0;
		int firstStrLength = strArr[0].length();
		
		boolean terminate = false;
		while(true){
			if(index < firstStrLength){
				char focus = strArr[0].charAt(index);
				for(int i=1; i<strArr.length; i++){
					if(focus != strArr[i].charAt(index)){
						terminate = true;
						break;
					}
				}
				if(terminate)
					break;
				else
					longestPrefix.append(Character.toString(focus));
				
				index++;
			}else
				break;
		}
		return longestPrefix.toString();
	}

}
