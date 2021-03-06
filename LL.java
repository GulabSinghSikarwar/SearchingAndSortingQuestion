public class LL {
    node head;

    class node {
        node next;
        int data;

        node(int data) {
            this.next = null;
            this.data = data;

        }
    }

    public void addFirst(int data) {

        node newNode = new node(data);
        // if list is empty

        if (head == null) {
            head = newNode;

            return;

        } else {
            newNode.next = head;
            head = newNode;

        }

    }

    public void addLast(int data) {
        node newNode = new node(data);

        if (head == null) {
            head = newNode;
            return;

        }
        if (head.next == null) {
            head.next = newNode;
            return;

        }
        node temp = head;

        while (temp.next != null) {
            temp = temp.next;

        }
        temp.next = newNode;

    }

    public void printList() {

        node temp = head;

        if (head == null) {
            System.out.println("List is empty ");

            return;

        }
        while (temp != null) {
            System.out.print(temp.data + " -->");

            temp = temp.next;

        }
        System.out.print("NULL");

    }

    public void removeFirst() {
        if (head == null) {

            System.out.println(" LIST IS EMPTY , CAN' T REMOVE ");
            return;

        }
        if (head.next == null) {
            head = null;
            System.out.println("NOW LIST IS EMPTY ");

            return;
        }
        head = head.next;

    }

    public void removeLast() {
        if (head == null) {
            System.out.println("LIST IS EMPTY ");
        }
        if (head.next == null) {
            head = null;
            System.out.println("NOW LIST IS EMPTY ");

            return;

        }
        node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return;

    }

    public void removeDuplicatesSorted(){
        node temp=head;

        while(temp.next!=null)
        {
            if(temp.next.data==temp.data)
            {

                node current=temp;

                while(temp.next.data==current.data)
                {
                    temp=temp.next;


                }
                current.next=temp.next;


            }
            temp=temp.next;
            



        }

    }

    public static void main(String[] args) {

        LL ll = new LL();
        // myLinkedList.addFirst(1);

        // myLinkedList.printList();

        // System.out.println();
        // myLinkedList.addFirst(2);
        // myLinkedList.addFirst(3);
        // myLinkedList.addFirst(4);
        // myLinkedList.addFirst(5);
        // myLinkedList.addFirst(6);
        // myLinkedList.printList();
        // System.out.println();
        // myLinkedList.removeFirst();
        // // removed first i.e 6
        // System.out.println();
        // myLinkedList.printList();
        // System.out.println();
        // myLinkedList.removeLast();
        // // removed last i.e 1

        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.printList();
        ll.removeDuplicatesSorted();
        ll.printList();

    }
}
