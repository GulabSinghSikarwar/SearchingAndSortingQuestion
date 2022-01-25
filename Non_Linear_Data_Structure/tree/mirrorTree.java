
package tree;
import java.util.*;
public class mirrorTree {
    void mirror(Node root) {
        // Your code here
        
     
        
        // mirror(root.left);
        // mirror(root.right);
        // Node temp=root.left;
        // root.left=root.right;
        // root.right=temp;
        
        Queue<Node> q=new  LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            
            Node temp=q.peek();
            q.poll();
            Node node=temp.left;
            temp.left=temp.right;
            temp.right=node ;
            
            if(temp.left!=null)
            {
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
                
            }
        }
        
        
    }
    
}
