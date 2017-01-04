package unit3;

import java.util.*;

class TreeNodet{
    public TreeNodet left;
    public TreeNodet right;
    public int value;

    public TreeNodet(int data){
        value = data;
        left = null;
        right = null;
    }
}

class BST{   
    public TreeNodet root;
    
    public BST(){
    	root = null;
    }

    public void insert(TreeNodet root, int key){

        if(key<root.value){
            if(root.left == null){
                root.left = new TreeNodet(key);
            }else{
                insert(root.left, key);
            }    
        }else{
            if(root.right == null){
                root.right = new TreeNodet(key);
            }else{
                insert(root.right, key);
            }
        }
    }
    
    public ArrayList<Integer> preOrder(TreeNodet node){
        if(node == null)
            return null;
        else{
            ArrayList<Integer> left = preOrder(node.left); 
            ArrayList<Integer> right = preOrder(node.right);
            ArrayList<Integer> al = new ArrayList<Integer>();
            
            al.add(node.value);
            if(left != null)
                al.addAll(left);
            if(right != null)
                al.addAll(right);
            return al;
        }
    }
    
    public void preOrderTraversal(TreeNodet node){
    	if(node == null)
    		return;
    	
    	System.out.print(node.value+" ");
    	preOrderTraversal(node.left);
    	preOrderTraversal(node.right);
    }
}

public class PreOrderCompare {
    
    public static void main(String[] args) throws Exception {
        try(Scanner sc = new Scanner(System.in);){
        	int qCount = sc.nextInt();
            
            for(int i=0; i<qCount; i++){
                int keyCount = sc.nextInt();
                int keys[] = new int[keyCount];
                for(int j=0; j<keyCount; j++){
                    keys[j] = sc.nextInt();
                }    
                
                BST bst = createBST(keys);
                
                
                ArrayList<Integer> pre = bst.preOrder(bst.root);
                
//                bst.preOrderTraversal(bst.root);
                
                if(bst.root == null)
                	System.out.println("Root is null");
                
                if(compare(keys, pre))
                    System.out.println("YES");
                else
                    System.out.println("NO");
                
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
    
    public static BST createBST(int[] keys) {

        BST bst = new BST();

        for(int i=0; i<keys.length; i++){
            if(bst.root == null){
                bst.root = new TreeNodet(keys[i]);
            }else{
                bst.insert(bst.root, keys[i]);
            }
        }
        
        return bst;
    }

    
    public static boolean compare(int[] keys, ArrayList<Integer> pre){
                
        boolean identical = true;
        
        
        Iterator<Integer> itr = pre.iterator();
        int i = 0;
        while(itr.hasNext()){
            Integer current = itr.next();
            if(keys[i] != current.intValue()){
                return false;
            }
            i++;
        }
        
        return identical;
    }
}
