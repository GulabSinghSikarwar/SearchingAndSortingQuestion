package tree;
import java.util.*;
public class tatt {
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
