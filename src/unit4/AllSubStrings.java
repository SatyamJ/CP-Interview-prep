package unit4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class AllSubStrings implements SubstringProvider{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String input = sc.next();
		
		AllSubStrings a = new AllSubStrings();
		ArrayList<String> substrings = a.getSubstrings(input);
		a.print(substrings);
		sc.close();
	}

	public ArrayList<String> getSubstrings(String str){
		ArrayList<String> al = new ArrayList<String>();
		int n = str.length();
		for(int i=0; i<n; i++){
//			al.addAll(getSubstringsIterative(str, i, n));
			al.addAll(getSubstringsRecursive(str, i, n));
		}
		return al;
	}
	
	public void print(ArrayList<String> alist){
		Iterator<String> itr = alist.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next() + " ");
		}
	}
	
	public ArrayList<String> getSubstringsIterative(String s, int start, int end){
		ArrayList<String> al = new ArrayList<String>();
		for(int i=start; i<end; i++){
			al.add(s.substring(start, i+1));
		}
		return al;
	}
	
	public ArrayList<String> getSubstringsRecursive(String s, int start, int end){
		if(end-start == 1){
			ArrayList<String> als = new ArrayList<String>();
			als.add(s.substring(start, end));
			return als;
		}
		
		ArrayList<String> als1 = getSubstringsRecursive(s, start, end-1);
		als1.add(s.substring(start, end));
		return als1;
	}
	
}
