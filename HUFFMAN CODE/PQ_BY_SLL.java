package ASSIGNEMENT;

public class PQ_BY_SLL {
    // head of priority singly linked list
    public NodeQueue head;

    // a method to add a node to the linked list
    void add(NodeTree tree) {
        // head of the list like current to be updated
        NodeQueue current = head;
        // seding the data of the tree to a constructor that suitable with tree data
        NodeQueue newNode = new NodeQueue(tree);
        // if we heve head and the new frequency less than head's frequency 
        if (head != null && head.frequency > tree.frequency) {
            // then put new node in left side of head
            newNode.next = head;
            // update the head to new node
            head = newNode;
        } 
        // so the frequency is not less or the head is null or both
        else {
            // if we have head
            if (current != null) {
                // if we have  a node after the head
                if (current.next != null) {
                    // while the next of the current node not null and the frequency of the new node greater than nodes of the linked list
                    while (current.next != null && current.next.frequency <= tree.frequency) {
                        // go to next node
                        current = current.next;
                    }
                    // so now put the new node in last place either if we have a node greater than new node
                    // or last node is empty
                    newNode.next = current.next;
                    current.next = newNode;
                } 
                // if we only have head so put the new node in right side of the head
                else {
                    current.next = newNode;
                }
            }
            // if we don't have head directly put the new node on the head place
            else {
                head = newNode;
            }
        }
    }
}
// a node class for the linked list
class NodeQueue {
    // frequency and character of each node because we have node of tree inside likned list node so we need
    // those variable for searching and puting tree nodes in correct place and protect the order from low to high
    int frequency;
    // next of each node that tell us next node after current node
    NodeQueue next;
    // Idea of using this variable comes from Gemini AI to solve a problem in TEXT class there is more detail in the TEXT class
    NodeTree treeRef;
    // constructor to intialize information of node of linked list with node of tree informations
    NodeQueue(NodeTree node) {
        // mathing frequency and character of tree node to linked list node
        this.frequency = node.frequency;
        // storing refrence each node of tree in here we use it later in TEXT class
        this.treeRef = node;
    }
}
