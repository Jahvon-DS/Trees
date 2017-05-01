
public class TreeNode {

	    class Node{ // data structure of each node
	        final String data; //stores data
	        Node left; //resresents left child
	        Node right; //represents right child
	        int count;

	        public Node(String data) { // constructor to create node
	            this.data = data;
	            left = right = null;
	            count = 1;          
	        }

	        public int compareTo(Node o) { //compare to another node
	            return data.compareTo(o.data); //returns -ve if other node is larger
	        }
	    }
	    Node root;

	    public TreeNode() {
	        root = null; //initialize
	    }
}
