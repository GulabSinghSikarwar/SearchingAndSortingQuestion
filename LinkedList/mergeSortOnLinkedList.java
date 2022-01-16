import java.lang.Thread.State;

public class mergeSortOnLinkedList{
    static class Node {
        int data;
        Node next;

        Node(int d)
        {
            this.data = d;
            this.next = null;
        }
    }


    public static Node getMiddle(Node head){
        if(head==null)
        return  null;
        // return ;

        
        Node fast=head;
        Node slow=head;
        while(fast.next !=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;


        }
        return slow;


    }

    public static Node mergeSort(Node head){
        
        
        if(head==null || head.next==null)
        return head;


        Node middle=getMiddle(head);
        Node nextOfMiddle=middle.next;


        middle.next=null;

        Node left =mergeSort(head);
        Node right =mergeSort(nextOfMiddle);


        Node  sortedList=merge(left,right);
        
      
        return null;


    }

    private static Node merge(Node a, Node b) {
       
        Node result=null;

        if(a==null)
        return b;
        
        if (b==null) {
            return a;

        }

        if (a.data<=b.data) {
            
            result=a;
            
            result.next=merge(a.next, b);

        }
        else{
            result=b;
            result.next=merge(a, b.next);
        }

        return result;
    }


     public static Node partition(Node start  , Node end ){


        if (start == end || start ==null || end == null) {
            return start ;

        }
        
        Node pivot_prev=start;
        Node curr=start ;
        
        int pivot=end.data;

        while (start!=end) {
            
            if (start.data < pivot) {

                pivot_prev=curr;
                int  temp=curr.data;

                curr.data=start.data;
                start.data=temp;

                curr=curr.next;

                
            }

            start=start.next;

        }
        int temp=curr.data;
        curr.data=pivot;
        end.data=temp;



        return pivot_prev;

    }
   
    
    public static  void sort (Node start ,Node end ){

        if (start ==null || start ==end ||  start ==end.next) {
            return;
        }

        Node pivot_prev=partition(start, end);

        sort(start, pivot_prev);

        if (pivot_prev!=null &&  pivot_prev==start ) {
            sort(pivot_prev.next, end);
        }
        else if (pivot_prev!=null 
        && pivot_prev.next!=null
        ) {
            sort(pivot_prev.next, end);
            
        }


    }
    public static Node getEnd(Node head){
        if (head==null) {
            return head;
        }
        
        Node temp =head;
        while(temp!=null)
        temp=temp.next



        return null;

    }
}