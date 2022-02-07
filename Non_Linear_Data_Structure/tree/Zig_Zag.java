package tree;
import java.util.*;

public class Zig_Zag {
     class  Node {
         Node left;
         Node right;
         int data;


    }
    ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	     ArrayList<Integer> list = new ArrayList<>();

      
         boolean isOdd=true;

         Stack <Node > main=new Stack<Node>();
         
         main.push(root);
         
         list.add(root.data);


         while( main.isEmpty()){

            int size=main.size();

            Stack <Node> temp =new Stack<Node>();

            for (int i = 0; i < size; i++) {
            
                if (isOdd) {
                    
                    Node peek=main.peek();
                    
                    main.pop();

                    if (peek.right!=null) {
                        
                        temp.push(peek.right);
                        
                        list.add(peek.right.data);

                    }
                    if (peek.left!=null) {
                        temp.push(peek.left);
                        
                        list.add(peek.left.data);
                    }
                }
                else{
                    Node peek=main.peek();
                    
                    main.pop();
                   
                    if (peek.left!=null) {
                        temp.push(peek.left);
                        
                        list.add(peek.left.data);
                    }

                    if (peek.right!=null) {
                        
                        temp.push(peek.right);
                        
                        list.add(peek.right.data);

                    }

                }
            }
            if (isOdd) {
                isOdd=false;
            }
            else{
                isOdd=true
            }
            main.addAll(temp)


         }





        return list;
	}
    public static void main(String[] args) {
        Stack <Integer> st= new Stack<>();
        Stack <Integer> stack= new Stack<>();
        st.push(3);
        st.push(4);
        st.push(6);
        stack.addAll(st);
        System.out.println(" stack : "+stack);

        int n=stack.size();
        for (int i = 0; i < n; i++) {
            System.out.println(stack.pop());
        }
    }
    
}
