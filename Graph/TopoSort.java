import java.util.*;

public class TopoSort {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here

       boolean [] visited =new boolean [V];
       Stack <Integer> stack =new Stack<>();

       Arrays.fill(visited, false);
       
       for (int i = 0; i < visited.length; i++) {
           if(!visited[i])
           {
               topologicalSort(adj, visited,stack,i);
               
           }
       }
       
       int ans [] =new int [V];
       for (int i = 0; i < ans.length; i++) {
           int peek=stack.peek();
           stack.pop();
           ans[i]=peek;

       }



        return ans;
    }

    private static void topologicalSort(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack,
            int i) {
                visited[i]=true;
                
                Iterator<Integer> it=adj.get(i).listIterator();

                while(it.hasNext())
                {
                    int n=it.next();

                    if (!visited[n]) {
                        topologicalSort(adj, visited, stack, n);
                    }
                }
                

                stack.push(i);



    }

    public static void main(String[] args) {

    }
}
