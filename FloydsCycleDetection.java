import java.util.HashSet;
import java.util.Set;
 
// A Linked List Node
class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
 
class Main
{
    // Function to detect a cycle in a linked list using hashing
    public static boolean detectCycle(Node head)
    {
        Node curr = head;
        Set<Node> set = new HashSet<>();
 
        // traverse the list
        while (curr != null)
        {
            // return false if we already have seen this node before
            if (set.contains(curr)) {
                return true;
            }
 
            // insert the current node into the set
            set.add(curr);
 
            // move to the next node
            curr = curr.next;
        }
 
        // we reach here if the list does not contain any cycle
        return false;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = {1, 2, 3, 4, 5};
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        // insert cycle
        head.next.next.next.next.next = head.next.next;
 
        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle Found");
        }
    }
}
