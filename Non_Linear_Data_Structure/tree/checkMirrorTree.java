package tree;
import java.util.*;
public class checkMirrorTree {
    static int checkMirrorTreeUtil(int n, int e, int[] a, int[] b) {
        // code here
        
        boolean ans = true ;
        
        Stack < Integer > stack =new Stack <>();
        
        Queue< Integer > q=new LinkedList<>();

        
        int i=0;
        
        stack.push(a[i]);
        
        q.add(b[i]);
        while( !q.isEmpty() )
        {
            int  size=stack.size();
            for(int cs=0;cs<size;cs++)
            {
                int stackPeek=stack.peek();
            int qPeek=q.peek();
            if(!(stackPeek==qPeek))
            {
                ans=false;
                break;

            }
            else{
                stack.pop();
                q.remove();
                for(int j=0;j<n;j++)
                {
                    stack.push(a[i+1]);
                    
                    q.add(b[i+1]);
                    i++;
                    

                }

            }
            } 

        }
        
        
        
        
    return 0;
    
    }
    
}
