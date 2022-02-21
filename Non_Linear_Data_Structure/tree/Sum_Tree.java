package tree;

import java.util.*;

public class Sum_Tree {

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }
        
        public void toSumTree(Node root){

            
            
       }
       public int sumtree(Node root){
           if(root==null)
           return 0;
           
           int sum= root.data+sumtree(root)



       }

}