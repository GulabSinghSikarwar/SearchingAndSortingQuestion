import java.util.*;

public class CloneWithRandomPointers {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Map<Node, Node> map = new HashMap<>();
        Node temp=head;

        while(temp!=null)
        {
            map.put(temp, new Node (temp.val));
            temp=temp.next;
            
        }

        temp=head;
        while(temp!=null)
        {
            Node tempsClone=map.get(temp);

            //  placing clones next at its position 

            tempsClone.next=map.get(temp.next);
         

            //  now place the random of the clones 
            Node random=temp.random;
            Node randomsClone=map.get(random);
            tempsClone.random=randomsClone;

            // now move ahead 
            temp=temp.next;


        }
        








        return null;
    }

}
