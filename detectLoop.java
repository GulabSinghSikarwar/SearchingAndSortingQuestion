import java.util.*;
import java.io.*;
import java.lang.*;
public class detectLoop {
    
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            if( x.detectLoop(head) )
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class Solution {
    
    public static boolean detectLoop(Node head){
    
        Node fast =head;
        Node slow=head;
        boolean loop = false;

        while (slow!=null && fast!=null && fast.next!=null) {
            
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
              loop = true;
                break;

            }

        }
        if(loop)
        return true;
        
       


        
        return false;

    }
}
