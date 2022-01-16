package LinkedList;

import java.util.PriorityQueue;

public class SortKsortedDLL 
{
    class Node {
        Node next;
        Node prev;
        int data;
        Node(int data){
            this.prev=null;
            this.next=null;
            this.data=data;


        }

    }
    Node head;

    public static void sort(int k,Node head)
 {
     PriorityQueue <Node> pq=new PriorityQueue<>();
     
     Node temp=head;
     for (int i = 0; i <= k; i++) {
         pq.add(temp);
        if (temp.next!=null) {
            temp=temp.next;
        }

     }
     // first element is taken out and made as head 


      head=pq.poll();

      // prev points to  node previous to  current node 



      head.prev=null;
      Node prev=head;
      //  now we added current temp node 

      pq.add(temp);



      // while pq is not empty  we run this loop 
      while(!pq.isEmpty())
      {
          Node curr=pq.poll();

          // prev----->current 
          
          prev.next=curr;
          // prev<-----current 

          curr.prev=prev;

        //                            temp-------->temp.next 
        //                                              |
        //                                              temp   
         

        //                            prev -------->current  
        //                                              |
        //                                              prev-------- new cuurent
        //                                                           ( will be created)            

          prev=curr;
          pq.add(temp);
          if (temp.next!=null) {
              temp=temp.next;
              pq.add(temp);
              
          }

      }




    }
}
