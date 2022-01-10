public class removeDuplicates {
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
    public static void main(String[] args) {
        
        
        

    }


    }


