public class segregatesOnesTwos {
    
    class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
    class Solution
    {
        //Function to sort a linked list of 0s, 1s and 2s.
    //     static Node segregate(Node head)
    //     {
    //         if(head==null || head.next==null)
            
    //         return head;
            
    //         // add your code here
    //         Node headZero=null;
    //         Node headOne=null;
    //         Node headTwo=null;
    //         Node temp=head ;
    //         Node tempZero=null;
    //         Node tempOne=null;
    //         Node tempTwo=null;
            
            
    //         while(temp!=null)
    //         {
              
                
    
    //   if(temp.data==0)
    
    // {
    //   if(headZero==null)
    //                 {
    //                     headZero=temp;
    //                     tempZero=headZero;
    //                 }else{
    //                     tempZero.next=temp;
    //                     tempZero=temp;
                        
    //                 }}
                    
                    
                    
                    
    //                 //1
                    
                    
    //  else if(temp.data==1)
    // {
    //  if(headOne==null)
    //                 {
    //                     headOne=temp;
    //                     tempOne=headOne;
    //                 }else{
    //                     tempOne.next=temp;
    //                     tempOne=temp;
                        
    //                 } }
                    
    //                 //2
                    
                    
                    
                    
    
    
    
    //  else if(temp.data==2)
    // {
    
    //  if(headTwo==null)
    //                 {
    //                     headTwo=temp;
    //                     tempTwo=headTwo;
    //                 }else{
    //                     tempTwo.next=temp;
    //                     tempTwo=temp;
                        
    //                 }
    // }
    //              temp=temp.next;
                
    //         }
            
    //      tempZero.next=null;
    //       tempOne.next=null;
    //       tempTwo.next=null;
           
    //         tempZero.next=headOne;
    //         tempOne.next=headTwo;
    //         return headZero;
            
    //     }
     static Node segregate(Node head)
        {
            if(head==null|| head.next==null)
            return head ;
            
          int zeroCount=0;
          int oneCount=0;
          int twoCount=0;
          
          Node temp=head;
          
          while(temp!=null)
          {
               if(temp.data==0)
               {zeroCount++;}
               else if(temp.data==1)
               {oneCount++;}
               else{ twoCount++;}
               temp=temp.next;
               
          }
        //   System.out.println("0: "+zeroCount);
        //   System.out.println("1: "+oneCount);
        //   System.out.println("2: "+twoCount);
          temp=head;
         
          
          
          while(zeroCount-->0)
          {
              temp.data=0;
              temp=temp.next;
          }
          while(oneCount-->0)
          {
              temp.data=1;
              temp=temp.next;
          }while(twoCount-->0)
          {
              temp.data=2;
              temp=temp.next;
          }
    
    return head ;    }
    }
    
    
    
}
}
