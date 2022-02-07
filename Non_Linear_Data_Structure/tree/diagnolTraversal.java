package tree;
import java.util.*;

public class diagnolTraversal {
    class Tree
{
    // Node is defined as
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    class node {
        Node  root;
        int level;
        
       node (Node root,  int level)
        {
            this.root=root;
            this.level=level;
            
        }
    }
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
        //   ArrayList <Integer> ans=new ArrayList <>();
           
        //   TreeMap< Integer  , ArrayList <Integer > > map = new TreeMap<>();
           
        //   Queue<node > q=new LinkedList ();
           
        //   q.add(new node (root ,0));
           
        //   while(!q.isEmpty())
        //   {
              
        //       node peek= q.peek();
        //       q.poll();
        //       Node peekNode=peek.root;
              
        //       if(map.containsKey (peek.level))
        //       {
        //           map.get(peek.level).add(peekNode.data);
                  
        //       }
        //       else{
        //           ArrayList <Integer> list =new ArrayList <>();
        //           list.add(peekNode.data);
                  
        //           map.put(peek.level,list);
        //       }
        //       if(peekNode.left!=null)
        //       {
        //           node val= new node (peekNode.left,peek.level+1); 
        //           q.add(val);
        //       }
              
        //       if(peekNode.right!=null)
        //       {
        //           node val=new node (peekNode.right,peek.level);
                  
        //           q.add(val);
                  
        //       }
              
        //     //   System.out.println(map);
              
              
        //   }
           
        //   for(int key : map.keySet())
        //   {
        //       ArrayList <Integer> list  =map.get(key);
        //       for(int value :list  )
        //       {
        //           ans.add(value);
                   
        //       }
        //   }
           
           
        //   return ans ;
        
           Queue<Node> q=new ArrayDeque<>();
           ArrayList<Integer> list=new ArrayList<Integer>();
           q.add(root);
           while(!q.isEmpty())
           {
             Node temp=q.poll();
             while(temp!=null)
             {
              list.add(temp.data);
              if(temp.left!=null)
              {
                q.add(temp.left); 
              }
               temp=temp.right;
             }
           }
           return list;
           
      }
}
}
