public class removeLoop {
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node fast=head;
        Node slow=head;
        
        boolean loop=false ;
        
        while(slow!=null && fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                loop=true;
                break;
            }
            
        }
        
        //  now // 1 2 3 4 5  
        //           ^|____|^     
        //        
        // 
         int count=1;
          boolean removed=false;
          
          
        if(loop)
        {
         
            
            fast=fast.next;
            
            while(fast!=slow)
            {
              
                count++;
                 fast=fast.next;
                
            }
             
         
            slow=head;
            fast=head;
            
         
           
           for(int i=0;i<count;i++)
                {
                  
                    
                    fast=fast.next;
                    
                    
                }
           
          while(fast!=slow)
        {
            slow=slow.next;
            fast=fast.next;
            
        }
        while(fast.next!=slow)
        {
            fast=fast.next;
        }
        fast.next=null;
        
            
        }
       
      
        
        
    }
}
