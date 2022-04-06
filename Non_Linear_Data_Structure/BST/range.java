public class range {
    
class Tree
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        int count =getCount_FromInorder(root,l,h);
        
        //Your code here
        // System.out.println("\n Count = "+count );
        
  return count  ;   }
    //  constant space inorder algorithms 
    
    int getCount_FromInorder(Node root, int l , int h ){
        if(root==null )
        return 0;
        
    int count=0 ;
    
        Node pre ;
        
        Node current = root ;
        
        while(current != null )
        {
            if(current.left == null )
            {
                int data =current.data;
                if(data>=l && data<=h)
                {
                    count++;
                    
                }
                
                // System.out.print(current.data+" -->");
                current=current.right;
            }
            else {
                pre=current.left ;
                
                while(pre.right !=null && pre.right !=current )
                {
                    pre=pre.right ;
                }
                if(pre.right==null)
                {
                    pre.right=current;
                    current=current.left;
                }
                else {
                     int data =current.data;
                if(data>=l && data<=h)
                {
                    count++;
                    
                }
                    // System.out.print(current.data+" -->");
                    pre.right=null;
                    current=current.right;
                    
                }
            }
        }
   return count ;  }
}

}
