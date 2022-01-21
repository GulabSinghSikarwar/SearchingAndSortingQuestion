import java.util.LinkedList;

public class DeleteNodeHavingSmallerValyeThanFollowing {


    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    int size = 0;

    
    Node compute(Node head)
    {
        // your code here
        head=reverse(head);
        
         Node curr=head;
            while (curr!=null && curr.next!=null) {
                Node next=curr.next;
            if (curr.data>next.data) {
               curr.next=next.next;
               next.next=null;

            }
            else
            {
                curr=next;
            }

            }
             head=reverse(head);
            
        return head ;
        
        
    }
    public Node reverse(Node head)
    {
        if(head==null || head.next==null)
        {
            
            // System.out.println(" Rev fun call : return ");
            
            
            return head;
        }
        
        Node prev=head;
        Node curr=head.next;
        
        while(curr!=null)
        {
            Node next=curr.next;
            
            curr.next=prev;
            prev=curr;
            curr=next;
            
        }
        head.next=null;
        head=prev;
        // System.out.println(" Rev fun call :: success ! ");
            
            
        return head ;
        
    }
   

    public Node reverse() {
        if (head == null || head.next == null)
            return head;

        Node prev = head;
        Node curr = prev.next;

        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head.next = null;
        head = prev;

        return head;

    }

    public void print() {
        if (head == null) {
            System.out.println("Null");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;

        }
        System.out.print("Null");

    }

    public void addData(int data) {
        if (head == null) {
            head = new Node(data);
            return;

        }
        Node node = new Node(data);

        node.next = head;
        head = node;
        this.size++;

    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        // LinkedList <Integer> ll=new LinkedList<>();
        int arr[] = { 12, 15, 10, 11, 5, 6, 2, 3 };

        // for (int i = 0; i < arr.length; i++) {

        // ll.add(arr[i]);
        // }

        DeleteNodeHavingSmallerValyeThanFollowing ll = new DeleteNodeHavingSmallerValyeThanFollowing();
        for (int i = 0; i < arr.length; i++) {

            ll.addData(arr[i]);
        }
        int size = ll.size();
        System.out.println(" size : " + size);

        // System.out.println(ll);
        System.out.println();
        ll.print();
        ll.reverse();
        System.out.println();
        ll.print();

        ll.reverse();
        System.out.println();
        ll.print();

    }
}
