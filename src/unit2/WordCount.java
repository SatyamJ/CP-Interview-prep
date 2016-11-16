package unit2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordCount {

	public static void main(String[] args) {
		String str = "To be or not to be, that b:e is the question";
		
		WordCount w = new WordCount();
		HashMap<String, Integer> wordMap = w.getWordMap(str); 
		w.display(wordMap);
		
		HashMap<Integer,HashSet<String>> reverse = w.computeReverseMap(wordMap);
		
		System.out.print("\nReverse map:");
		w.displayReverse(reverse);
	}
	
	public HashMap<String, Integer> getWordMap(String s){
		HashMap<String, Integer> wMap = new HashMap<String, Integer>();
		
		String[] tokens = s.split(" ");
		
		for(int i=0; i<tokens.length; i++){
			StringBuffer sb = new StringBuffer(tokens[i].toLowerCase());
			
			int n = sb.length();
			for(int j=0; j<n; j++){
				char focus = sb.charAt(j);
				if(!(focus>='a' && focus<='z')){
					sb.replace(j, j+1, "");
					n--;
				}	
			}
			
			if(sb.length() != 0 ){
				int prevCount = 0;
				if(wMap.containsKey(sb.toString()))
					prevCount = wMap.get(sb.toString()).intValue();
				
				wMap.put(sb.toString(), new Integer(prevCount + 1));
			}
		}	
		return wMap;
	}
	
	public void display(HashMap<String, Integer> map){
		Set<String> keySet= map.keySet();
		Iterator<String> itr = keySet.iterator();
		while(itr.hasNext()){
			String word = (String) itr.next();
			System.out.println(word + " -> " + map.get(word));
			
		}
	}
	
	public HashMap<Integer, HashSet<String>> computeReverseMap(HashMap<String, Integer> map){
		
		HashMap<Integer, HashSet<String>> reverseMap = new HashMap<Integer, HashSet<String>>();
		
		Set<String> keySet = map.keySet();
		Iterator<String> itr = keySet.iterator();
		while(itr.hasNext()){
			String focusKey = (String) itr.next();
			Integer focusValue = map.get(focusKey);
			
			if(reverseMap.containsKey(focusValue)){
				HashSet<String> currentSet = reverseMap.get(focusValue);
				currentSet.add(focusKey);
			}else{
				HashSet<String> currentSet = new HashSet<String>();
				currentSet.add(focusKey);
				reverseMap.put(focusValue, currentSet);
			}
		}
		return reverseMap;
	}
	
	public void displayReverse(HashMap<Integer, HashSet<String>> map){
		Set<Integer> keySet= map.keySet();
		Iterator<Integer> itr = keySet.iterator();
		
		while(itr.hasNext()){
			Integer key = (Integer) itr.next();
			HashSet<String> valueSet = map.get(key);
			System.out.print("\n"+key.intValue()+" -> {");
			
			Iterator<String> setItr = valueSet.iterator();
			if(setItr.hasNext())
				System.out.print(setItr.next());
			while(setItr.hasNext()){
				System.out.print(","+setItr.next());
			}
			System.out.print("}");
		}
	}
}
