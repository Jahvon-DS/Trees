import java.io.*;
import java.util.Scanner;
public class TreeNode {

	    class Node{ // data structure of each node
	         //stores data
	        Node left; //resresents left child
	        Node right; //represents right child
	        int count;
	        String key; 

	        public Node(String data) { // constructor to create node
	           key  = data;
	            left = right = null;
	            count = 1;          
	        }

	    public String toString(){
	    	return key + " " + count; 
	    }
	        
	    }
	    Node root;

	    public TreeNode() {
	        root = null; //initialize
	    }
	    // used to call insert
	    void insert (String key){
	    	if(root == null)
	    		root = new Node(key);
	    	else
	    	   insertIt(root, key);
	    }
Node insertIt(Node root, String key){
	//if the tree is empty return a new node
	if(root == null){
		root = new Node(key);
		return root;
	}
	if (root.key.compareTo(key)== 0){
		root.count = root.count +1; 
		return root;
	}
	//if not traverse thru the tree 
	else if(key.compareTo(root.key)< 0)
		root.left = insertIt(root.left,key);
	else {
		root.right = insertIt(root.right,key); 
	}
	return root; 
}
//calls inorderIt
void inorder(){
	inorderIt(root);
}
		 
	 //does an inorder traversal 
	 void inorderIt(Node root){
		 if (root!= null ){
			 inorderIt(root.left);
	System.out.println(root.key +" " +root.count); 
	inorderIt(root.right);
		 }
	 }

public boolean search(String key){
	return searchIt(root, key);
	
}
private boolean searchIt(Node root, String key){
//if root is null or no key is there
	if (root ==null){
		return false;
	}
	if (root.key == key){
		return true;
	}
	//if its greater than the key
	if(root.key.compareTo(key)> 0){
		return searchIt(root.left,key); 
	}
	else{
		//if its less than 
		return searchIt(root.right,key); 
	}
	
}
	// This calls delete
	void deleteKey(String key){
		root = deleteIt(root, key); 
		
	}
	   //inserting a new key recursively
	Node deleteIt(Node root, String key){
		// if tree is empty 
		if (root == null){
			return root;
		
		}
		if (key.compareTo(root.key)<0){
			root.left = deleteIt(root.left, key);
		}
		else if (key.compareTo(root.key)>0){
			root.right = deleteIt(root.right, key);
		
		}
		 else

	       {

	           // node with only one child or no child
	           if (root.left == null){
	               return root.right;
	           }
	           else if (root.right == null){
	               return root.left;
	           }
	        root.key = minValue(root.right);
	        //deleting the inorder
	        root.right = deleteIt(root.right,root.key);
	       }
		return root; 
	   
		
	}
	String minValue(Node root){
		String minVal = root.key;
		while (root.left != null){
			minVal = root.left.key; 
			root = root.left;
		}
		return minVal;
	}
	
	public void inOrderTraversal(Node focusNode) {
		if (focusNode != null) {
			inOrderTraversal(focusNode.left);
			System.out.print(focusNode + " ");
			inOrderTraversal(focusNode.right);
		}
	}

	  private static void printInfix (Node root){
    if(root == null)
        return; //terminating condition
    printInfix(root.left); //go to left
    System.out.println(root.key + " " + root.count); //print own value
    printInfix(root.right); //then go to right
}


	  public static void main(String[] args) throws IOException { //driver method
		  TreeNode tree = new TreeNode();
		  File filename = new File ("TreeWork.txt");
	     Scanner keyboard = new Scanner(filename);
		while (keyboard.hasNext()){
			String temp = keyboard.next();
			tree.insert(temp);
		
		}
		tree.inOrderTraversal(tree.root);
	tree.insert("");
			
			//	TreeNode tree = new TreeNode();
	       // System.out.println("Enter a sentence:");
	      //  String[] inputWords = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" "); //sorry for this complex line
	      //  for (String w:inputWords)
	       //     tree.insert(w.trim().toLowerCase());
	      // printInfix(tree.root);
		keyboard.close();
	    }
	  
}



