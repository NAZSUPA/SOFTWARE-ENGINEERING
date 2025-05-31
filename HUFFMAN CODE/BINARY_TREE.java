package ASSIGNEMENT;

public class BINARY_TREE {

    // root of the binary tree
    public  NodeTree root;
    // the answer of encoded input
    public String encode = "";
    // number of frequency of each character inside the input
    public int FrequencyNumber = 0;
    // public object for the binary tree
    public static BINARY_TREE object = new BINARY_TREE();

    // method to add root of tree
    public void addNode(NodeTree New) {
        // add to root
        if (root == null) {
            root = New;
        }
    }
    // this codes idea theoritically comes from Gemini AI and implemented by myself 
    // and I with AI together debug the methods problems 
    // except this part all other codes of this file are mine codes
    
    // a main method to traverse the tree and generate code for each character
    public String generateCode(NodeTree root,char letter) {
        // root of the tree
        NodeTree current = root;
        // send to a helper method to traverse the tree
      return  object.TraversTree(current, encode, letter);
    }
    //  a helper method to traverse the tree to find a path from root to a character
    public String TraversTree(NodeTree node, String encode, char letter) {
        // storing left and right path in different string while traverse both side
        String left;
        String right;
        // base case if we reach a leaf node because all nodes that have the characters are leaf nodes
        if (node.left == null && node.right == null) {
            // if the node contain the character we search for
            if (node.character == letter) {
                // return the path you found
                return encode;
            }
        }
         // if not reach a leaf node
        else {
            // search left side and add 0 for each search of left side and store the value in a left string
        left = TraversTree(node.left, encode + "0", letter);
        // only if left string have a content then return it 
        if(left != null){
        return left;
        }
        // if left is null then search right
        else{
            // search right side and add 1 for each search of right side and store the value in a right string
        right = TraversTree(node.right, encode + "1", letter);
        // only if right string have a content then return it 
        if(right != null){
            return right;
        }
        }
        }
        
        // if none of them happend then we don't have this character in the tree so return null
        return null;
    }
}

// node class for the tree
class NodeTree {

    // frequency and character inside each node
    int frequency;
    char character;
    // parent and left child and right child of each node
    NodeTree parent;
    NodeTree left;
    NodeTree right;
    
    // a constructor for normal nodes that inialize frequency and character of each node
    NodeTree(int frequency, char character) {
        this.frequency = frequency;
        this.character = character;
    }
    // a constructor that used in mixing tree when sum frequency added but not nead any character for new root 
    NodeTree(int frequency) {
        this.frequency = frequency;
    }
}
