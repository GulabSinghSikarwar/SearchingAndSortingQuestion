package tree;

import java.util.*;
import java.io.*;

public class LeftViewOfTree {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    ArrayList<Integer> leftView(Node root)
    {
         ArrayList<Integer> list = new ArrayList<>();
        //  if(ro    // Your code hereot==n)
  
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        // Map<Integer, Integer> map = new HashMap<>();

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                Node peek = q.peek();
                if (i == 0)
                  { 
                    //   map.put(level, peek.data);

                      list.add(peek.data);
                  }
                q.poll();
                if (peek.left != null)
                    q.add(peek.left);

                if (peek.right != null)
                    q.add(peek.right);

            }

        }
        // System.out.println("Map : depicting level and their first Value : " + map);

        return list;
    }

    public static void main(String[] args) throws IOException {

    }
}

class Tree
{
    int max_level = 0;
    
    //Function to get the left view of the binary tree.
    void leftViewUtil(ArrayList<Integer> result, Node node, int level)
    {
        //if root is null, we simply return.
        if (node==null) return;
        
        //if this is the first node of its level then it is in the left view.
        if (max_level < level)
        {
            //storing data of current node in list.
            // result.add(node.data);
            max_level = level;
        }
        
        //calling function recursively for left and right 
        //subtrees of current node.
        leftViewUtil(result, node.left, level+1);
        leftViewUtil(result, node.right, level+1);
    }
    
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
		leftViewUtil(result, root, 1);
		//returning the list.
		return result;
    }
}