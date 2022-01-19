import java.util.Arrays;
import java.util.Comparator;

public class MergeK_SortedLinkedLists {

    class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }
   
 void print(Node head) 
    {
    
            //  printing  the  list 
            if (head==null) {
                System.out.println("NULL");
            }

            Node temp=head;
            while (temp!=null) {
                System.out.print( temp.data+" -->");
                temp=temp.next;

            }
            System.out.print("NULL");
            System.out.println();
   
    }
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        
          Arrays.sort(arr,new Comparator<Node>() {
            @Override 
            public int compare(Node nodeOne, Node nodeTwo)
            {
                if (nodeOne.data == nodeTwo.data)
                return 0;
            else if (nodeOne.data > nodeTwo.data)
                return 1;
            else
                return -1;
            }
        });
        Node head=null;
        Node temp=head;
        boolean gotHead=false;
        for (int i = 0; i < arr.length; i++) {
            if (!gotHead) {
                head=merge(head, arr[i]);
                temp=head;
             gotHead=true;
             print(head);
             

            }
            else{
                temp=merge(temp, arr[i]);
            print(temp);
            }
        }
      
        
        
        return temp;


    }
    Node merge(Node a,Node b)
    {
        if(a==null)return b;
        if (b==null)return a;

        Node result;
        if (a.data<b.data) {
            result=a;
            result.next=merge(a.next, b);

        }
        else{
            result=b;
            result.next=merge(a, b.next);

        }
       return result;

    }
  
}
