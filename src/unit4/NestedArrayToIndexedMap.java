package unit4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class NestedArrayToIndexedMap {

	public static void main(String[] args) {
		Object[] arr = {"A", "B", new Object[]{"C", "D"}, "E", new Object[]{"F", new Object[]{"G", "H"}}, "I"};
		NestedArrayToIndexedMap n = new NestedArrayToIndexedMap();
		
		HashMap<int[], Object> terminalIndexedMap = new HashMap<int[], Object>();
		
		terminalIndexedMap = n.findMappings(arr, new ArrayList<Integer>(), terminalIndexedMap); 
		
		n.print(terminalIndexedMap);
	}
	
	public HashMap<int[], Object> findMappings(Object[] arr, ArrayList<Integer> indices, HashMap<int[], Object> indexedMap){
		
		int n = arr.length;
		for(int i=0; i<n; i++){
			if(arr[i] instanceof Object[]){
				ArrayList<Integer> index = new ArrayList<Integer>();
				if(!indices.isEmpty())
					index.addAll(indices);
				index.add(new Integer(i));
				indexedMap = findMappings((Object[])arr[i], index, indexedMap);
			}else{
				ArrayList<Integer> index = new ArrayList<Integer>();
				if(!indices.isEmpty())
					index.addAll(indices);
				index.add(new Integer(i));
				int[] coordinates = convertArrayListtoArray(index);
				indexedMap.put(coordinates, arr[i]);
			}
		}
		
		return indexedMap;
	}
	
	public int[] convertArrayListtoArray(ArrayList<Integer> arr){
		int n = arr.size();
		int[] desired = new int[n];
		
		int i=0;
		for(Integer x: arr){
			desired[i++] = x.intValue();
		}
		return desired;
	}

	public void print(HashMap<int[], Object> map){
		Iterator itr = map.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry entry = (Map.Entry) itr.next();
			int[] indices = (int[])entry.getKey();
			
			if(indices.length > 0){
				System.out.print("[");
				System.out.print(indices[0]);
				for(int i=1; i<indices.length; i++)
					System.out.print(", "+indices[i]);
				System.out.print("]: ");	
			}
			System.out.println(entry.getValue());
		}
	}
}
