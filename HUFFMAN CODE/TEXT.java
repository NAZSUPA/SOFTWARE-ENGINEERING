package ASSIGNEMENT;

public class TEXT {
    // object for helper classes
    public static PQ_BY_SLL queue = new PQ_BY_SLL();
    public static BINARY_TREE Tree = new BINARY_TREE();
    // object for this class
    public static TEXT object = new TEXT();
    // head of the priority linked list
    public static NodeQueue head = queue.head;

    // a method for counting frequency of each character of a sentence and storing both the character and its frequency in a root of a new tree
    public void CouontLetters(String sentence) {
        // local variable to store each character frequency start from zero
        int frequency = 0;
        // looping over all sentence character
        for (int i = 0; i < sentence.length(); i++) {
            // if the character is counted then skip this character
            // sending the character, the sentenece, the index of the character 
            if (!IsCounted(sentence.charAt(i), sentence, i)) {
                // a local object to create new binary tree
                BINARY_TREE NewTree = new BINARY_TREE();
                // count the character it self for first time
                frequency = 1;
                // a loop from the character index + 1 until last character
                for (int j = i + 1; j < sentence.length(); j++) {
                    // if the character found
                    if (sentence.charAt(i) == sentence.charAt(j)) {
                        // frequency + 1
                        frequency++;
                    }
                }
                // add the character and its frequency to a new tree (make it a root of a new tree)
                NewTree.addNode(new NodeTree(frequency, sentence.charAt(i)));
                // storing the new tree root inside a varaible
                NodeTree Tree = NewTree.root;
                // send the new tree to the priority likned list or (queue)
                queue.add(Tree);
                // update the frequency again to zero for next character
                frequency = 0;
            }
        }
        // calling a method to mix all tree (nodes inside queue) to one binary tree
        object.MixTrees(head);
    }
    // a helper method to check that a chaaracter is counted or not 
    // the sentence + the character + the index of the character is needed
    public boolean IsCounted(char character, String sentence, int index) {
        // looping froom index 0 to the character
        for (int i = 0; i < index; i++) {
            // if the character is found then the character is counted
            if (sentence.charAt(i) == character) {
                // then return true
                return true;
            }
        }
        // if the character not found so not counted return false
        return false;
    }

    // a method to mix all tree in the queue to one tree only the head of the queue is needed
    public void MixTrees(NodeQueue head) {
        // a local variable to temporarly store sum of frequency of 2 character
        int SumFrequency;
        // while the queue is has more than one tree
        while (queue.head.next != null) {
            // the head is first tree
            NodeQueue first = TEXT.queue.head;
            // the tree after head is second tree
            NodeQueue second = TEXT.queue.head.next;

            // suming frequency both of first and second tree (character's frequency)
            SumFrequency = first.frequency + second.frequency;
            // creating new root for a new tree and lable it parent
            NodeTree NewParent = new NodeTree(SumFrequency);

            // if there is isn't root in the tree then add new parent like a root
            // it's only for first time mixing
            if (Tree.root == null) {
                Tree.addNode(NewParent);
            }
            // for after first time of mixing
            else {
                // make the root of the tree new parent 
                Tree.root = NewParent;
            }
            // make new parent parent of both first and second tree 
            // in here we used treeRef variable to reach node refrecene to make this connection between nodes inside the queue and new tree root like parent
            first.treeRef.parent = NewParent;
            second.treeRef.parent = NewParent;
            // make first left child of root of new tree
            Tree.root.left = first.treeRef;
            // make second right child of root of new tree
            Tree.root.right = second.treeRef;
            // upate the head to 2 next node of the queue to disconnect the first and second node from the tree 
            // garbage collection handle the deletion
            queue.head = queue.head.next.next;
            // adding the new tree we created inside the queue for to mix it also with future trees
            queue.add(NewParent);
        }
    }
        // a method to encode a sentence
    public String Encode(String sentence) {
        // a local variable to temporarly store the code
        String EncodeResult = "";
        // looping over all characters of the sentence
        for (int i = 0; i < sentence.length(); i++) {
            // using another method insde BINARY_TREE class to return codes
            // and add the return value for each character's code inside a variable
            EncodeResult += Tree.generateCode(Tree.root, sentence.charAt(i));
        }
        // return codes for all characters of the sentence
        return EncodeResult;
    }
    // a method to decode an encoded sentence
    public String Decode(String sentence) {
        // a local variable to temporarly store the the characters behind the code
        String DecodeResult = "";
        // root of the mixed tree
        NodeTree current = Tree.root;
        // storing index outside loop start from zero
        int i = 0;
        // while we have a sentence and is not null
        if (!sentence.isEmpty() && sentence != null) {
            // while not reach the last character
            while (i < sentence.length()) {
                // while not reaching a leaf node inside a mixed tree
                while (current.left != null || current.right != null) {
                    // if the coded sentence has 1 go to righ side node
                    if (sentence.charAt(i) == '1') {
                        current = current.right;
                        // go to next character
                        i++;
                    } 
                    // if coded sentence has 0 go to left side node
                    else if(sentence.charAt(i) == '0'){
                        current = current.left;
                        // go to next character
                        i++;
                    }
                    // else directly update index to last character to stop the loop and break;
                    else{
                    i = sentence.length();
                    // update content of the decode string to tell the user input was wrong
                    DecodeResult = "wrong input";
                    break;
                    }
                }
                // reaching correct character add it to the decode strig 
                DecodeResult += current.character;
                // update the current node to the root start from the node for next time
                current = Tree.root;
            }
        }
        // return what is charaters behind 0 and 1
        // or return the wrong input message
        return DecodeResult;
    }
}
