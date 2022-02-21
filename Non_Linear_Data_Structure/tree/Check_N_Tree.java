package tree;

import java.util.*;


public class Check_N_Tree
 {
    int checkMirrorTree(int n, int e, int[] a, int[] b) {
        
        List <Stack <Integer>> stack=new ArrayList <>();
        List <Queue<Integer>> queue=new ArrayList <>();


        for (int i = 0; i <=n; i++) {
            stack.add(new Stack<>());
            Queue <Integer> small=new LinkedList<>();
            queue.add(small);


        }
        for (int i = 0; i <=2*e; i+=2) {
            stack.get(a[i]).push(a[i+1]);
            queue.get(b[i]).add(b[i+1]);

            
        }
        for (int i = 1; i<=n; i++) {
            while(!stack.get(i).isEmpty() && !queue.get(i).isEmpty())
            {
                int a=stack.get(i).pop();
                int b=queue.get(i).poll();
                if (a!=b) {
                    return 0;
                    
                }
            } 
            
        }
        
        return 0;
    }
}
